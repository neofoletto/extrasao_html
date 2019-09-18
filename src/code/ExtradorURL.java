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

import manip_files.ManipHTML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ExtradorURL {

  private String texto = "";

  public ExtradorURL() {

  }

  public ExtradorURL(String url, String code) {
    switch (url.split(".")[1]) {
      case "urionlinejudge":
        uri(url, code);
        break;

      default:
        return;
    }
  }

  public String uri(String siteUrl, String code) {
    Usuario user = new Usuario();
    String INICIOURI = "profile-bar";
    String FIMURI = "information-box";
    String textoHtml = "";
    boolean mostra = false;

    try {
      java.net.URL url = new URL(siteUrl + code);
      URI uri = url.toURI();
      BufferedReader html = new BufferedReader(new InputStreamReader(url.openStream()));
      String aux_texto;
      while ((aux_texto = html.readLine()) != null) {
        if (aux_texto.toLowerCase().contains(INICIOURI))
          mostra = true;
        if (aux_texto.toLowerCase().contains(FIMURI))
          mostra = false;

        if (mostra) {
          textoHtml += aux_texto + System.lineSeparator();
        }
      }

      this.texto = textoHtml.replaceAll("<[^>]*>", ";").replace("&ordm;", "");
      for (int i = 0; i < 5; i++)
        this.texto = this.texto.replaceAll(System.lineSeparator(), "").replaceAll("  ", "").replaceAll(";;", ";");
      user = new Usuario(this.texto.substring(1).split(";"));

      new ManipHTML(user.getName(), textoHtml);
      html.close();
    } catch (MalformedURLException excecao) {
      excecao.printStackTrace();
    } catch (URISyntaxException excecao) {
      excecao.printStackTrace();
    } catch (IOException excecao) {
      excecao.printStackTrace();
    }
    return user.toString();
  }
}