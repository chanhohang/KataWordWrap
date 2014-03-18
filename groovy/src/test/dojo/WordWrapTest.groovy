package dojo

evaluate(new File("src/main/dojo/WordWrap.groovy"))

import static org.junit.Assert.*;
import groovy.util.GroovyTestCase

class Test extends GroovyTestCase {
	
	void testWrap_normalcase() {
		assert "hello" == dojo.WordWrap.wrap('hello', 5);
		assert "he\nll\no" ==  dojo.WordWrap.wrap('hello', 2)
		assert "hel\nlo" ==  dojo.WordWrap.wrap('hello', 3)
	}
	
	void testWrap_boundarycase()
	{
		assert "hello" == dojo.WordWrap.wrap('hello', 5);
		try
		{
		assert "hello" == dojo.WordWrap.wrap('hello', 0);
		} catch (Exception e)
		{
			assert 'Invalid Column Width : 0. Column Width must be bigger than 0.' == e.getMessage() 
		}
		
	}
	
}

