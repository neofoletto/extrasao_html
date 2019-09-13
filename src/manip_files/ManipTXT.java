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

package manip_files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author neo
 * @date 12/09/2019
 */
public class ManipTXT {

  final private String EXTENSAO = ".html";
  final private String PATH     = "file/";
  private String nomeDoArquivo  = "semnome" + EXTENSAO;
  private Formatter output      = null;

  public ManipTXT(String nomeDoArquivo, String texto) {
    setNomeDoArquivo(nomeDoArquivo);
    abrirArquivo();
    escrever(texto);
    fecharArquivo();
  }

  public boolean abrirArquivo() {
    try {
      output = new Formatter(new File(this.nomeDoArquivo));
      return true;
    } catch (SecurityException se) {
      System.out.println("Voce nao tem permissao para gravar este arquivo - ");
      System.out.print(se);
      System.exit(1);
    } catch (FileNotFoundException fnf) {
      System.out.println("Erro ao criar arquivo - ");
      System.out.print(fnf);
      System.exit(1);
    }
    return false;
  }

  public void escrever(String texto) {
    try {
      output.format(texto.replaceAll("  ", "") + "\n");
    } catch (Exception e) {
      System.out.println("ERRO: " + e.toString());
    }
  }

  public void fecharArquivo() {
    try {
      output.close();
    } catch (Exception e) {
      System.out.println("ERRO: " + e.toString());
    }

  }

  public String ler() {
    Scanner input = null;
    Vector<String> vetor = new Vector<String>();
    try {
      input = new Scanner(new File(this.nomeDoArquivo));
    } catch (SecurityException se) {
      System.out.println("Voce nao tem permissao para abrir este arquivo - ");
      System.out.print(se);
      System.exit(1);
    } catch (FileNotFoundException fnf) {
      System.out.println("Erro ao abrir arquivo - ");
      System.out.print(fnf);
      System.exit(1);
    }
    try {
      while (input.hasNext())
        vetor.add(input.nextLine());
    } catch (NoSuchElementException nsee) {
      System.out.println("Arquivo esta mal formatado. - ");
      System.out.print(nsee);
      input.close();
      System.exit(0);
    } catch (IllegalStateException ise) {
      System.out.println("Erro ao ler arquivo. - ");
      System.out.print(ise);
      System.exit(0);
    }
    if (input != null) {
      input.close();
    }
    return vetor.toString();
  }

  public void limparArquivo() {
    abrirArquivo();
  }

  public String getNomeDoArquivo() {
    return this.nomeDoArquivo;
  }

  public void setNomeDoArquivo(String nomeDoArquivo) {
    if (nomeDoArquivo.length() != 0)
      this.nomeDoArquivo = PATH + nomeDoArquivo.replace(" ", "").replace(".", "") + EXTENSAO;
  }
}
