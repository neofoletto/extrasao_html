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
 * @author neo
 * @date 12/09/2019
 */
package code;

import manip_files.ManipTXT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtradorURL {

    final private String URL = "https://www.urionlinejudge.com.br/judge/en/profile/";
    final private String INICIO = "profile-bar";
    final private String FIM = "information-box";
    private boolean mostra = false;
    private String texto = "";

    ExtradorURL() {

    }

    public String uri(String code) {
        Usuario user = new Usuario();
        String[] aux = new String[7];
        int count = 0;

        StringBuilder builder = new StringBuilder();
        try {
            java.net.URL url = new URL(URL + code);
            URI uri = url.toURI();
            BufferedReader html = new BufferedReader(new InputStreamReader(url.openStream()));
            String aux_texto;
            while ((aux_texto = html.readLine()) != null) {
                if (aux_texto.toLowerCase().contains(INICIO))
                    mostra = true;
                if (aux_texto.toLowerCase().contains(FIM))
                    mostra = false;

                if (mostra) {
                    if (aux_texto.toLowerCase().contains("<a href=\"/judge/en/profile/")) {
                        user.setName(aux_texto.split(">")[1].replace("</a", ""));
                    } else if (aux_texto.toLowerCase().contains("&ordm")) {
                        user.setPlace(aux_texto.split("&ordm")[0].trim());
                    } else if (aux_texto.toLowerCase().contains("<a href=\"/judge/en/users/country\"")) {
                        user.setCountry(aux_texto.split(">")[1].replace("</a>            </li>", "").replace("</a", ""));
                    } else if (aux_texto.toLowerCase().contains("<a href=\"/judge/en/users/university/ifc\"")) {
                        user.setUniversity(aux_texto.split(">")[2].replace("</i></a>            </li>", "").replace("</i", ""));
                    } else if (aux_texto.toLowerCase().contains("            </li>")) {
                        aux[count] = aux_texto.split("<")[0].trim();
                        count++;
                    }
                  texto += aux_texto;
                }
            }
            user.setSince(aux[0]);
            user.setPontis(aux[1]);
            user.setSolved(aux[2]);
            user.setTried(aux[3]);
            user.setSubmissions(aux[4]);
            ManipTXT manip = new ManipTXT(user.getName(), texto);
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