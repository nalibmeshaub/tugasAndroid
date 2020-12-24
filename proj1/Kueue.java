package nachos.proj1;
import java.util.Vector;
import nachos.threads.KThread;
import nachos.threads.ThreadQueue;
public class Kueue extends ThreadQueue {
	Vector<KThread> kurwaThreads = new Vector<KThread>();
	public Kueue() {
	}
	@Override
	public void waitForAccess(KThread thread) {
		this.kurwaThreads.add(thread);
	}
	@Override
	public KThread nextThread() {
		if(kurwaThreads.isEmpty()) return null;
		return kurwaThreads.remove(0);
	}
	@Override
	public void acquire(KThread thread) {
		
	}
	@Override
	public void print() {
		
	}
}
