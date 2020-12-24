package nachos.proj1;
import java.util.Vector;
import nachos.machine.FileSystem;
import nachos.machine.Machine;
import nachos.machine.MalformedPacketException;
import nachos.machine.NetworkLink;
import nachos.machine.OpenFile;
import nachos.machine.Packet;
import nachos.threads.KThread;
import nachos.threads.Semaphore;
public class Primary {
	Konsol kurwa = new Konsol();
	NetworkLink doge = Machine.networkLink();
	Semaphore kurwaSem = new Semaphore(0);
	Vector<Tugas> kurwaTask = new Vector<Tugas>();
	public Primary() {
		int cyka = 0;
		if(doge.getLinkAddress() == 0) {
			Runnable receiveInterruptHandler = new Runnable() {
				@Override
				public void run() {
					Packet kurwaPkt = doge.receive();
					String temp = new String(kurwaPkt.contents);
					kurwaTask.add(new Tugas(kurwaPkt.srcLink, temp));
				}
			};
			Runnable sendInterruptHandler = new Runnable() {
				@Override
				public void run() {
					kurwaSem.V();
				}
			};
			doge.setInterruptHandlers(receiveInterruptHandler, sendInterruptHandler);
			do {
				kurwa.tulisan("Welcome Admin");
				kurwa.tulisan("=============");
				kurwa.tulisan("1. View all tasks");
				kurwa.tulisan("2. Execute all tasks");
				kurwa.tulisan("3. Exit");
				cyka = kurwa.bacaAngka();
				if(cyka == 1) {
					if(kurwaTask.isEmpty()) {
						kurwa.tulisan("Gone");
						kurwa.baca();
					} else {
						kurwa.tulisan("List");
						kurwa.tulisan("====");
						for(Tugas tugas : kurwaTask)kurwa.tulisan("User " + tugas.getNum() + ": " + tugas.getTask());
						kurwa.baca();
					}
				} else if(cyka == 2) {
					if(kurwaTask.isEmpty()) {
						kurwa.tulisan("Gone");
						kurwa.baca();
					} else {
						while(!kurwaTask.isEmpty()) {
							String temp = "Done";
							try {
								Packet kurwaPkt = new Packet(kurwaTask.elementAt(0).getNum(), 0, temp.getBytes());
								doge.send(kurwaPkt);
								kurwaSem.P();
							} catch (MalformedPacketException e) {
								e.printStackTrace();
							}
							new KThread(kurwaTask.remove(0)).fork();
						}
					}
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					kurwa.tulisan("Done");
					kurwa.baca();
				}
			} while (cyka != 3);
		} else {
			Runnable receiveInterruptHandler = new Runnable() {
				@Override
				public void run() {
					kurwaTask.removeAllElements();
				}
			};
			Runnable sendInterruptHandler = new Runnable() {
				@Override
				public void run() {
					kurwaSem.V();
				}
			};
			doge.setInterruptHandlers(receiveInterruptHandler, sendInterruptHandler);
			do {
				kurwa.tulisan("Welcome User " + doge.getLinkAddress());
				kurwa.tulisan("=============");
				kurwa.tulisan("1. View current tasks");
				kurwa.tulisan("2. View executed tasks");
				kurwa.tulisan("3. Queue a task");
				kurwa.tulisan("4. Exit");
				cyka = kurwa.bacaAngka();
				if(cyka == 1) {
					if(kurwaTask.isEmpty()) {
						kurwa.tulisan("Gone");
						kurwa.baca();
					} else {
						kurwa.tulisan("List");
						kurwa.tulisan("====");
						for(Tugas tugas : kurwaTask)kurwa.tulisan(tugas.getTask());
						kurwa.baca();
					}
				} else if(cyka == 2) {
					FileSystem fs = Machine.stubFileSystem();
					OpenFile file = fs.open(doge.getLinkAddress() + ".txt", false);
					if(file == null) {
						kurwa.tulisan("None");
						kurwa.baca();
					} else {
						byte[] temp = new byte[file.length()];
						file.read(0, temp, 0, file.length());
						String S = new String(temp);
						String[] split = S.split("\n");
						kurwa.tulisan("Task");
						kurwa.tulisan("====");
						for (String string : split) kurwa.tulisan(string);
						kurwa.baca();
					}
				} else if(cyka == 3) {
					String temp;
					kurwa.tulisan("Task: ");
					temp = kurwa.baca();
					kurwaTask.add(new Tugas(doge.getLinkAddress(), temp));
					try {
						Packet kurwaPkt = new Packet(0, doge.getLinkAddress(), temp.getBytes());
						doge.send(kurwaPkt);
						kurwaSem.P();
					} catch (MalformedPacketException e) {
						e.printStackTrace();
					}
				}
			} while (cyka != 4);
		} kurwa.tulisan(Machine.timer().getTime());
	}
}
