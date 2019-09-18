/*
 *                     GNU GENERAL PUBLIC LICENSE
 *                        Version 3, 29 June 2007
 *
 *  Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 *  Everyone is permitted to copy and distribute verbatim copies
 *  of this license document, but changing it is not allowed.
 *
 *                             Preamble
 *
 *   The GNU General Public License is a free, copyleft license for
 * software and other kinds of works.
 */

/**
 * @author neo, JotaSouza
 * @date 12/09/2019
 */
package code;

public class Main {

  public static void main(String[] args) {
    ExtradorURL ex = new ExtradorURL();

    System.out.println(ex.uri("https://www.urionlinejudge.com.br/judge/en/profile/", "1515"));

  }
}
