package test;

import static org.junit.Assert.*;

import java.io.File;

import main.FileManip;
import main.StrManip;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StrManipTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFilterOutParamsForNextMessage() throws Exception {

		String text = FileManip.getContents(new File("text.txt"));
		
		String[] splittedAnswer = StrManip.filterOutParamsForNextMessage(text, "setFormActionAndSubmitAcLogInNew");
		
		for (String tmp: splittedAnswer){
			
			System.out.println(tmp);
			assertNotNull(tmp);
		}
	}
	
	@Test
	public void testFilterOutTheValueOf() throws Exception {

		String text = FileManip.getContents(new File("text2.txt"));
		
		String rc_rowid = StrManip.filterOutTheValueOf(text, "rc_rowid");
		
		assertEquals("AAAlEuAAhAAA7M+AAI", rc_rowid);
	}
	
}
