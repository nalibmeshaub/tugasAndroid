package nachos.proj1;
import nachos.machine.Machine;
import nachos.machine.SerialConsole;
import nachos.threads.Semaphore;
public class Konsol {
	SerialConsole kurwaKonsol;
	Semaphore kurwaSem;
	char kurwaTemp;
	public Konsol() {
		kurwaKonsol = Machine.console();
		kurwaSem = new Semaphore(0);
		Runnable sendInterruptHandler = new Runnable() {
			@Override
			public void run() {
				kurwaSem.V();
			}
		};
		Runnable receiveInterruptHandler = new Runnable() {
			@Override
			public void run() {
				kurwaTemp = (char) kurwaKonsol.readByte();
				kurwaSem.V();
			}
		};
		kurwaKonsol.setInterruptHandlers(receiveInterruptHandler, sendInterruptHandler);
	}
	public String baca() {
		String temp = "";
		do {
			kurwaSem.P();
			if(kurwaTemp == '\n') break;
			temp += kurwaTemp;
		} while (true);
		return temp;
	}
	public Integer bacaAngka() {
		String temp = baca();
		int tempInt;
		try {
			tempInt = Integer.parseInt(temp);
		} catch(Exception e) {
			return null;
		} return tempInt;
	}
	public void tulis(Object blyat) {
		String cyka = blyat.toString();
		for(int i = 0; i < cyka.length(); i++) {
			char shutUp = cyka.charAt(i);
			kurwaKonsol.writeByte(shutUp);
			kurwaSem.P();
		}
	}
	public void tulisan(Object blyat) {
		tulis(blyat + "\n");
	}
}
