public class WordWrap {

	public static String wrap(String inputStr, int columnWidth) {
		StringBuilder builder = new StringBuilder();

		int startIndex = 0, lastSpaceIndex = -1;
		for (int i = 0; i < inputStr.length(); i++) {
			char character = inputStr.charAt(i);
			switch (character) {
			case ' ':

				if (i >= builder.length() + columnWidth) {
					builder.append(inputStr.substring(startIndex, i)).append(
							'\n');
					startIndex = i + 1;
					lastSpaceIndex = i;
				} else if (i < builder.length() + columnWidth) {
					lastSpaceIndex = i;
				}

				break;
			case '\n':
				builder.append(inputStr.substring(startIndex, i)).append('\n');
				startIndex = i + 1;
				break;
			default:
				if (i > builder.length() + columnWidth && lastSpaceIndex > startIndex) {
					builder.append(
							inputStr.substring(startIndex, lastSpaceIndex))
							.append('\n');
					startIndex = lastSpaceIndex + 1;
					builder.append(inputStr.substring(startIndex, i));
					startIndex = i;
				}
			}
		}

		if (startIndex < inputStr.length()) {
			if (lastSpaceIndex > startIndex && inputStr.length() - startIndex > columnWidth) {
				builder.append(inputStr.substring(startIndex, lastSpaceIndex))
						.append('\n');
				startIndex = lastSpaceIndex + 1;
			}
			
			builder.append(inputStr.substring(startIndex));
		}

		return builder.toString();
	}
}
