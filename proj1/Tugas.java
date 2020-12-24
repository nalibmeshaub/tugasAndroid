package nachos.proj1;
import nachos.machine.FileSystem;
import nachos.machine.Machine;
import nachos.machine.OpenFile;
public class Tugas implements Runnable {
	private int num;
	private String task;
	public Tugas(int num, String task) {
		this.num = num;
		this.task = task;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	@Override
	public void run() {
		FileSystem fs = Machine.stubFileSystem();
		OpenFile file = fs.open(num + ".txt", false);
		if(file == null) file = fs.open(num + ".txt", true);
		String temp = task + "\n";
		file.write(file.length(), temp.getBytes(), 0, temp.length());
	}
}
