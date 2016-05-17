package it.unibs.ing.fp.lonelyhearts;

/**
 * <h1> Class LonelyHeart </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v2.0
 * @since 2016-04-05
 */

public class LonelyHeart {
	private static final int THRESHOLD_AGE = 10;
	
	private String nickname;
	private char sex;
	private int age;
	private Zodiaco segno;
	private Zodiaco segnoAffine;
	
	/**
	 * Constructor.
	 * @param nickname
	 * @param sex
	 * @param age
	 * @param segno
	 * @param segnoAffine
	 */
	public LonelyHeart(String nickname, char sex, int age, Zodiaco segno, Zodiaco segnoAffine) {
		this.nickname = nickname;
		this.sex = sex;
		this.age = age;
		this.segno = segno;
		this.segnoAffine = segnoAffine;
	}
	
	/**
	 * Constructor.
	 * @param nickname
	 * @param sex
	 * @param age
	 */
	public LonelyHeart(String nickname, char sex, int age) {
		this.nickname = nickname;
		this.sex = sex;
		this.age = age;
	}
	
	/**
	 * Returns true if there is an affinity between two LonelyHeart.
	 * @param partner
	 * @return <tt>true </tt> if there is an affinity between two LonelyHeart; <tt>false </tt> otherwise
	 */
	public boolean checkAffinity(LonelyHeart partner) {
		if(sexAffinity(partner.sex) && ageAffinity(partner.age) && zodiacoAffinity(partner.segno, partner.segnoAffine)) return true;
		return false;
	}
	
	/**
	 * Returns the nickname of Object LonelyHeart.
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}
	
	/**
	 * Returns true if there is affinity as sex between two LonelyHeart.
	 * @param sex
	 * @return <tt> true </tt> if the sexes are different; <tt>false </tt> otherwise
	 */
	private boolean sexAffinity(char sex) {
		if(this.sex != sex) return true;
		return false;
	}
	
	/**
	 * Returns true if there is affinity as age between two LonelyHeart.
	 * @param age
	 * @return <tt> true </tt> if the age differences are smaller than a certain threshold; <tt>false </tt> otherwise
	 */
	private boolean ageAffinity(int age) {
		if(Math.abs(this.age-age) <= THRESHOLD_AGE) return true;
		return false;
	}
	
	/**
	 * Returns true if there is affinity as Zodiac sign between two LonelyHeart.
	 * @param segno
	 * @param segnoAffine
	 * @return <tt> true </tt> if the Zodiac signs are equal; <tt>false </tt> otherwise
	 */
	private boolean zodiacoAffinity(Zodiaco segno, Zodiaco segnoAffine) {
		if(this.segnoAffine == segno && this.segno == segnoAffine) return true;
		return false;
	}
}
