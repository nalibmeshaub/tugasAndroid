package nachos.proj1;

import java.util.Vector;
import nachos.machine.Machine;
import nachos.machine.MalformedPacketException;
import nachos.machine.NetworkLink;
import nachos.machine.Packet;
import nachos.threads.KThread;
import nachos.threads.Semaphore;

public class Uts {
	Konsol k = new Konsol();
	Semaphore s = new Semaphore(0);
	NetworkLink n = Machine.networkLink();
	Vector<Item> v = new Vector<Item>();
	public Uts() {
		int cyka = -1;
		do {
			Runnable receiveInterruptHandler = new Runnable() {
				@Override
				public void run() {
					Packet p = n.receive();
					String temp = new String(p.contents);
					String[] split = temp.split("#");
					v.add(new Item(p.srcLink, split[1], split[0]));
					if(p != null) System.out.println(">>You have a new item request !!");
				}
			};
			Runnable sendInterruptHandler = new Runnable() {
				@Override
				public void run() {
					s.V();
				}
			};
			n.setInterruptHandlers(receiveInterruptHandler, sendInterruptHandler);
			k.tulisan("~mainKraf");
			k.tulisan("Player ID: Player-" + n.getLinkAddress());
			k.tulisan("===================");
			k.tulisan("1. Send Request");
			k.tulisan("2. View Request Box");
			k.tulisan("3. Craft Item");
			k.tulisan("4. Delete Request");
			k.tulisan("5. Exit");
			k.tulis(">>");
			cyka = k.bacaAngka();
			if(cyka == 1) {
				int id, q;
				String name, temp;
				k.tulisan("Send Request");
				k.tulisan("------------");
				k.tulisan("Input Player ID: ");
				id = k.bacaAngka();
				do {
					k.tulis("Input Item's Name[must be between 7-20 characters]: ");
					name = k.baca();
				} while(name.length() < 7 || name.length() > 20);
				do {
					k.tulis("Input Item's Quantity[must be more than or equal to 1]: ");
					q = k.bacaAngka();
				} while(q < 1);
				String test = Integer.toString(q);
				temp = "[" + name + "]#[" + test + "]";
				try {
					Packet p = new Packet(id, n.getLinkAddress(), temp.getBytes());
					n.send(p);
					s.P();
				} catch (MalformedPacketException e) {
					e.printStackTrace();
				} k.tulisan("Item request sent successfully!");
				k.baca();
			} else if(cyka == 2) {
				if(v.isEmpty()) {
					k.tulisan("There is no request yet!\n");
					k.tulis("Press ENTER to continue...");
					k.baca();
				} else {
					int num = 1;
					k.tulisan("View Request");
					k.tulisan("------------");
					for (Item item : v) {
						String n = Integer.toString(num);
						k.tulisan("(" + n + ")");
						num++;
						k.tulisan("Request from Player-" + item.getUser());
						k.tulisan("Item Name: " + item.getName());
						k.tulisan("Quantity: " + item.getQ());
						k.tulisan("");
					} k.tulis("\nPress ENTER to continue...");
					k.baca();
				}
			} else if(cyka == 3) {
				if(v.isEmpty()) {
					k.tulisan("There is no request yet!\n");
					k.tulis("Press ENTER to continue...");
					k.baca();
				} else {
					k.tulisan("Craft Item");
					k.tulisan("----------");
					int index = 0;
					while(!v.isEmpty()) {
						k.tulisan("Request from Player-" + v.elementAt(index).getUser());
						k.tulisan(v.elementAt(index).getName() + "(" + v.elementAt(index).getQ() + ") has been crafted!!!\n");
						new KThread(v.remove(0)).fork();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						} index++;
					} k.tulis("\nPress ENTER to Continue...");
					k.baca();
				}
			} else if(cyka == 4) {
				if(v.isEmpty()) {
					k.tulisan("There is no request yet!\n");
					k.tulis("Press ENTER to continue...");
					k.baca();
				} else {
					k.tulisan("Delete request");
					k.tulisan("--------------");
					int index = 0, num = 1;
					for (Item item : v) {
						k.tulisan("(" + num + ")");
						num++;
						k.tulisan("Request from Player-" + item.getUser());
						k.tulisan("Item Name: " + item.getName());
						k.tulisan("Quantity: " + item.getQ());
						k.tulisan("");
					} do {
						k.tulis("Choose item request to delete[1.." + v.size() + "]: ");
						index = k.bacaAngka();
					} while (index < 1 || index > v.size());
					v.remove(index - 1);
					k.tulisan("Request has been deleted\n");
					k.tulis("Press ENTER to continue...");
					k.baca();
				}
			}
		} while(cyka != 5);
		k.tulisan("Shutting down...");
		k.tulisan("Ticks of time: " + Machine.timer().getTime());
	}
}
