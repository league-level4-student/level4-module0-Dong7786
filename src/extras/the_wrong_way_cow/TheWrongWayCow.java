//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;

public class TheWrongWayCow {

	public static int[] findWrongWayCow(final char[][] field) {

		int[] position = new int[2];

		int up = 0;
		int down = 0;
		int left = 0;
		int right = 0;

		for (int i = 0; i < field.length; i++) {

			for (int k = 0; k < field[i].length; k++) {
				if (i < field.length-3 && field[i][k] == 'w' && field[i + 1][k] == 'o' && field[i + 2][k] == 'c') {
					right++;

				} else if (i < field.length-3 && field[i][k] == 'c' && field[i + 1][k] == 'o' && field[i + 2][k] == 'w') {
					left++;

				} else if (k < field[i].length-3 && field[i][k] == 'w' && field[i][k + 1] == 'o' && field[i][k + 2] == 'c') {
					up++;

				} else if (k < field[i].length-3 && field[i][k] == 'c' && field[i][k + 1] == 'o' && field[i][k + 2] == 'w') {
					down++;

				}

			}
		}
		
		
		System.out.println(up + ", " + down + ", " + left + ", "+ right);
		for (int i = 0; i < field.length; i++) {

			for (int k = 0; k < field[i].length; k++) {
				if (i < field.length-3 && field[i][k] == 'w' && field[i + 1][k] == 'o' && field[i + 2][k] == 'c' && right == 1) {
					position[1] = i+2;
					position[0] = k;

				} else if (i < field.length-3 && field[i][k] == 'c' && field[i + 1][k] == 'o' && field[i + 2][k] == 'w' && left == 1) {
					position[1] = i;
					position[0] = k;

				} else if (k < field[i].length-3 && field[i][k] == 'w' && field[i][k + 1] == 'o' && field[i][k + 2] == 'c' && up == 1) {
					position[1] = i;
					position[0] = k+2;

				} else if (k < field[i].length-3 && field[i][k] == 'c' && field[i][k + 1] == 'o' && field[i][k + 2] == 'w' && down == 1) {
					position[1] = i;
					position[0] = k;

				}

			}
		}
		System.out.println(position[0]+ ", " + position[1]);
		// Fill in the code to return the x,y coordinate position of the
		// head (letter 'c') of the wrong way cow!

		return position;
	}
}
