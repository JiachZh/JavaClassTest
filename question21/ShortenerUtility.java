/*
 * Name: 
 * Student number: 
 */

/*
 * A command-line application that shortens a message.
 */
public class ShortenerUtility {
    // to be completed 
	
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("Please input a message:");
		}else {
			StringBuilder message = new StringBuilder();
			for(int i = 0;i<args.length;i++) {
				String s = args[i];
				if(i == args.length-1) {
					message.append(s);
				}else {
					message.append(s+" ");
				}
			}
			Shortener shortener = new Shortener();
			System.out.println(shortener.shortenMessage(message.toString()));
		}
		
	}
}
