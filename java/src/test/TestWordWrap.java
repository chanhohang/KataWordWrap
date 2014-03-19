import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class TestWordWrap {

	@Parameters
	public static Collection<Object[]> init()
	{
		Object[][] data = new Object[][] { 
				{ "Hello Coper", 5 , "Hello\nCoper" }, 						//0
				{ "ULLINK" , 2 , "ULLINK" }, 
				{ "ABCDEFG HIJKLMNO", 10, "ABCDEFG\nHIJKLMNO" }, 
				{ "HI HI HI  I Am ABC", 9, "HI HI HI \nI Am ABC" }, 
				{ "HI HI HI  I Am ABC", 8, "HI HI HI\n I Am\nABC" }, 
				{ "ABC", 0 , "ABC"},										//5
				{ "HI" , -1 , "HI"},
				{ "Hello, I am UL", 5 , "Hello,\nI am\nUL"},
				{ "Hello, I\nam UL", 5 , "Hello,\nI\nam UL"},
				{ "Shit,\nI am UL", 6 , "Shit,\nI am\nUL"},
				{ "Hello,\nI am UL", 7 , "Hello,\nI am UL"},				//10
				{ "Hello, I am ULDASHBOARD", 5 , "Hello,\nI am\nULDASHBOARD"},
				{ "Yo, I am ULFLOW-FLEW.FLOW, FLEW", 5 , "Yo, I\nam\nULFLOW-FLEW.FLOW,\nFLEW"}
				};
		   return Arrays.asList(data);
	}
	
	private String input;
	private int columnWidth;
	private String expectedOutput;
	
	public TestWordWrap(String textInput, int columnWidth, String expectedOutput)
	{
		this.input = textInput;
		this.columnWidth = columnWidth;
		this.expectedOutput = expectedOutput;
	}
	@Test
	public void testInput()
	{
		Assert.assertEquals(expectedOutput, WordWrap.wrap(input, columnWidth));
	}
}
