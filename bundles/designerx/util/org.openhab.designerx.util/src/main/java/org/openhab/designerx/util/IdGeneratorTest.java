package org.openhab.designerx.util;

import org.junit.Test;
import org.openhab.designerx.util.IdGenerator.NoAvailableIdExeption;

public class IdGeneratorTest {
	private static final IdGenerator idGen = new IdGenerator();

	@Test
	public void testNewId() throws NoAvailableIdExeption, InterruptedException {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					printGeneratedIds();
				} catch (NoAvailableIdExeption e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread thread = new Thread(r);
		thread.start();
		printGeneratedIds();
	}
	
	private void printGeneratedIds() throws NoAvailableIdExeption, InterruptedException {
		for (int i = 0; i < 100; ++i) {
			System.out.println(Thread.currentThread().toString() + ", " + idGen.newId());
			Thread.sleep((long) ((long) 100 * Math.random()));
		}
	}

}
