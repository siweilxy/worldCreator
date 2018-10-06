package com.siwei.worldCreator;

public class GenerateSources extends Thread {
	@Override
	public void run() {
		this.setName("GenerateSources");
		while (true) {
			try {
				System.out.println("GenerateSources.run()");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
