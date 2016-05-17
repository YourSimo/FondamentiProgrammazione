package it.unibs.ing.fp.hello;

/**
 * <h1>Class Hello</h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v2.0 
 * @since 2016-03-01
 *
 */

public class Hello {
	
	/**
	 * Prints "Hello, World!".
	 */
	public static void sayHelloWorld() {
		System.out.println("Hello, World!");
	}
	/**
	 * Prints a welcome message to recipient.
	 * @param language - The welcome language
	 * @param target - The recipient
	 */
	public static void sayHelloTo(String language, String target) {
		System.out.println(language + ", " + target + "!");
	}
	
	/**
	 * Prints a message with exclamation mark (!). Useful for a welcome message.
	 * @param message - The message to be printed
	 */
	public static void sayHello(String message) {
		System.out.println(message + "!");
	} 
}
