package dojo

static def wrap(input, columnWidth)
{
	def result = '';
	def int index = 0;
	if (columnWidth <= 0)
	{
		throw new RuntimeException('Invalid Column Width : ' + columnWidth +". Column Width must be bigger than 0.")
	}
	while (index < input.length())
	{
		def int endIndex = index + columnWidth;
		if (endIndex > input.length())
		{
			endIndex = input.length();
		}

		//println(index + "|" + endIndex)
		result += input.substring(index,endIndex);
		if (endIndex < input.length())
		{
			result += '\n';
		}
		index += columnWidth;
	}
	return result;
}

