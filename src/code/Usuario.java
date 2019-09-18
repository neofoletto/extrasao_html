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

public class Usuario {

  private String name;
  private String place;
  private String country;
  private String university;
  private String since;
  private String pontis;
  private String solved;
  private String tried;
  private String Submissions;

  public Usuario() {

  }

  public Usuario(String[] informacao) {
    setName(informacao[0]);
    setPlace(informacao[2]);
    setCountry(informacao[4]);
    setUniversity(informacao[6]);
    setSince(informacao[8]);
    setPontis(informacao[10]);
    setSolved(informacao[12]);
    setTried(informacao[14]);
    setSubmissions(informacao[16]);
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    if (place.length() != 0)
      this.place = place;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    if (country.length() != 0)
      this.country = country;
  }

  public String getUniversity() {
    return university;
  }

  public void setUniversity(String university) {
    if (university.length() != 0)
      this.university = university;
  }

  public String getSince() {
    return since;
  }

  public void setSince(String since) {
    if (since.length() != 0)
      this.since = since;
  }

  public String getPontis() {
    return pontis;
  }

  public void setPontis(String pontis) {

    if (pontis.length() != 0)
      this.pontis = pontis;
  }

  public String getSolved() {
    return solved;
  }

  public void setSolved(String solved) {

    if (solved.length() != 0)
      this.solved = solved;
  }

  public String getTried() {
    return tried;
  }

  public void setTried(String tried) {
    if (tried.length() != 0)
      this.tried = tried;
  }

  public String getSubmissions() {
    return Submissions;
  }

  public void setSubmissions(String submissions) {
    if (submissions.length() != 0)
      Submissions = submissions;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Usuario").append("\n");
    sb.append("Name:        ").append(name).append('\n');
    sb.append("Place:       ").append(place).append('\n');
    sb.append("Country:     ").append(country).append('\n');
    sb.append("University:  ").append(university).append('\n');
    sb.append("Since:       ").append(since).append('\n');
    sb.append("Pontis:      ").append(pontis).append('\n');
    sb.append("Solved:      ").append(solved).append('\n');
    sb.append("Tried:       ").append(tried).append('\n');
    sb.append("Submissions: ").append(Submissions);
    return sb.toString();
  }
}
