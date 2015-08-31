
import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Principal {

    public static void main(String[] args) throws JDOMException {
        Scanner tec = new Scanner(System.in);
        int menu;
        System.out.println("Bem-Vindo, Escolha uma das seguintes opções\n1-Cadastrar novo curriculo\n2-Editar Curriculo\n3-Relatorio");
        menu = tec.nextInt();
        if (menu == 1) {
            Scanner tec2 = new Scanner(System.in);
            int id1;
            System.out.println("Digite o número de ID do ultimo curriculo criado");
            id1 = tec2.nextInt();
            XMLOutputter xout = new XMLOutputter();
            Element cv = new Element("cv");
            Element pessoa = new Element("pessoa");
            Element formacao = new Element("Formação");
            id1++;
            String ID = Integer.toString(id1);
            Attribute id = new Attribute("id", ID);
            pessoa.setAttribute(id);

            Element dadosPessoais = new Element("DadosPessoais");
            Element nome1 = new Element("Nome");
            Element sexo1 = new Element("Sexo");
            Element idade1 = new Element("Idade");

            System.out.println("Digite o nome do candidato");
            nome1.setText(tec.next());
            System.out.println("Digite o sexo Masculino/Feminino");
            sexo1.setText(tec.next());
            System.out.println("Digite a idade do candidato");
            idade1.setText(tec.next());

            dadosPessoais.addContent(nome1);
            dadosPessoais.addContent(sexo1);
            dadosPessoais.addContent(idade1);

            Element curso = new Element("Curso");
            Element instituicao = new Element("Instituição");

            Attribute nivel = new Attribute("Nivel", "Graduacao");
            System.out.println("Nome da Instituição: ");
            Attribute nomeinst = new Attribute("nome", tec.next());
            System.out.println("Digite o país da instituição: ");
            Attribute pais = new Attribute("país", tec.next());
            System.out.println("Nome do Curso:");
            Attribute nomecurso = new Attribute("curso", tec.next());
            System.out.println("Digite o ano de inicio do curso:");
            Attribute anoInicio = new Attribute("anoIni", tec.next());
            System.out.println("Digite o ano previsto de término do curso:");
            Attribute anoFim = new Attribute("anoFim", tec.next());

            instituicao.setAttribute(nomeinst);
            instituicao.setAttribute(pais);
            curso.setAttribute(nomecurso);
            curso.setAttribute(anoInicio);
            curso.setAttribute(anoFim);
            curso.setAttribute(nivel);
            instituicao.addContent(curso);
            formacao.addContent(instituicao);

            System.out.println("Possui Mestrado ?(1-sim/2-nao): ");
            int mestr = tec.nextInt();
            if (mestr == 1) {
                Attribute nivelM = new Attribute("Nivel", "Mestrado");
                Element instituicaoM = new Element("Instituição");
                Element cursoM = new Element("Curso");

                System.out.println("Nome da Instituição: ");
                Attribute nomeinstM = new Attribute("nome", tec.next());
                System.out.println("Digite o país da instituição: ");
                Attribute paisM = new Attribute("país", tec.next());
                System.out.println("Digite o nome do curso: ");

                Attribute nomecursoM = new Attribute("curso", tec.next());
                System.out.println("Digite o ano de inicio do curso:");
                Attribute anoInicioM = new Attribute("anoIni", tec.next());
                System.out.println("Digite o ano previsto de término do curso:");
                Attribute anoFimM = new Attribute("anoFim", tec.next());

                instituicaoM.setAttribute(nomeinstM);
                instituicaoM.setAttribute(paisM);
                cursoM.setAttribute(nomecursoM);
                cursoM.setAttribute(anoInicioM);
                cursoM.setAttribute(anoFimM);
                cursoM.setAttribute(nivelM);
                instituicaoM.addContent(cursoM);
                formacao.addContent(instituicaoM);
            }

            System.out.println("Possui Doutorado ?(1-sim/2-nao):");
            mestr = tec.nextInt();
            if (mestr == 1) {
                Attribute nivelD = new Attribute("Nivel", "Doutorado");
                Element instituicaoD = new Element("Instituição");
                Element cursoD = new Element("Curso");

                System.out.println("Digite as informações de formação");
                System.out.println("Nome da Instituição: ");
                Attribute nomeinstD = new Attribute("nome", tec.next());
                System.out.println("Digite o país da instituição: ");
                Attribute paisD = new Attribute("país", tec.next());
                System.out.println("Digite o nome do curso: ");
                Attribute nomecursoD = new Attribute("curso", tec.next());
                System.out.println("Digite o ano de inicio do curso:");
                Attribute anoInicioD = new Attribute("anoIni", tec.next());
                System.out.println("Digite o ano previsto de término do curso:");
                Attribute anoFimD = new Attribute("anoFim", tec.next());

                instituicaoD.setAttribute(nomeinstD);
                instituicaoD.setAttribute(paisD);
                cursoD.setAttribute(nomecursoD);
                cursoD.setAttribute(anoInicioD);
                cursoD.setAttribute(anoFimD);
                cursoD.setAttribute(nivelD);
                instituicaoD.addContent(cursoD);
                formacao.addContent(instituicaoD);
            }

            pessoa.addContent(dadosPessoais);
            pessoa.addContent(formacao);
            File f = new File("Curriculo.xml");
            try {
                if (!f.exists()) {
                    Document doc = new Document();
                    cv.addContent(pessoa);
                    doc.setRootElement(cv);
                    xout.setFormat(Format.getPrettyFormat());
                    OutputStream out = new FileOutputStream(f);
                    xout.output(doc, out);
                    System.out.println("Documento criado com sucesso!");
                } else {
                    SAXBuilder builder = new SAXBuilder();
                    Document doc = builder.build(f);
                    Element raiz = (Element) doc.getRootElement();
                    raiz.addContent(pessoa);
                    xout.setFormat(Format.getPrettyFormat());
                    OutputStream out = new FileOutputStream(f);
                    xout.output(doc, out);
                    System.out.println("Documento alterado com sucesso!");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (menu == 2) {
            String person;
            Scanner key = new Scanner(System.in);
            System.out.println("Deseja pesquisar por nome ou id?");
            if (key.next().equals("id")) {
                System.out.println("Qual o id desejado");
            } else {
                System.out.println("Qual o nome desejado");
            }
            person = tec.next();
            File f = new File("Curriculo.xml");
            SAXBuilder builder = new SAXBuilder();

            Document doc;
            try {
                doc = builder.build(f);
                Element cv = (Element) doc.getRootElement();

                List<Element> pessoas = cv.getChildren();

                for (Element pessoa : pessoas) {
                    System.out.println(pessoa.getChild("DadosPessoais").getChildText("Nome"));
                    if ((person.equals(pessoa.getAttributeValue("id"))) || (person.equals(pessoa.getChild("DadosPessoais").getChildText("Nome")))) {
                        System.out.println("Deseja Adicionar:\n1 - instituicao\n2 - Curso");
                        Element formacao = new Element("Formação");
                        Element curso = new Element("Curso");
                        Element instituicao = new Element("Instituição");
                        String grad, inst, paiz, curs, ini, fim;
                        

                        if (tec.next().equals("1")) {
                            System.out.println("Nome da Instituição: ");
                            pessoa.getChild("Formacão").addContent("Instituição").setAttribute("nome", tec.next());
                            System.out.println("Digite o país da instituição: ");
                            pessoa.getChild("Formacão").getChild("Instituição").setAttribute("pais", tec.next());
                            System.out.println("Qual o nível? [Graduação, Mestrado, Doutorado]");
                            pessoa.getChild("Formacão").getChild("Instituição").addContent("Curso").setAttribute("Nivel", tec.next());
                            System.out.println("Nome do Curso:");
                            curs = tec.next();
                            System.out.println("Digite o ano de inicio do curso:");
                            ini = tec.next();
                            System.out.println("Digite o ano previsto de término do curso:");
                            fim = tec.next();

                        } else {
                            inst = pessoa.getChild("Formação").getChild("Instituição").getAttributeValue("nome");
                            //pessoa.getChild("Formação").getChild("Instituição")
                            System.err.println(pessoa.getChild("Formação").getChild("Instituição").getAttributeValue("nome"));
                            System.err.println(pessoa.getChild("Formação").getChild("Instituição").getAttributeValue("país"));
                            System.out.println("Qual o nível? [Graduação, Mestrado, Doutorado]");
                            System.out.println("Nome do Curso:");
                            curs = tec.next();
                            System.out.println("Digite o ano de inicio do curso:");
                            ini = tec.next();
                            System.out.println("Digite o ano previsto de término do curso:");
                            fim = tec.next();
                        }
                        
//                        Attribute nivel = new Attribute("Nivel", grad);
//                        Attribute nomeinst = new Attribute("nome", inst);
//                        Attribute pais = new Attribute("país", paiz);
//                        Attribute nomecurso = new Attribute("curso", curs);
//                        Attribute anoInicio = new Attribute("anoIni", ini);
//                        Attribute anoFim = new Attribute("anoFim", fim);

//                        instituicao.setAttribute(nomeinst);
//                        instituicao.setAttribute(pais);
//                        curso.setAttribute(nomecurso);
//                        curso.setAttribute(anoInicio);
//                        curso.setAttribute(anoFim);
//                        curso.setAttribute(nivel);
//                        instituicao.addContent(curso);
//                        formacao.addContent(instituicao);
                        break;
                    }
                    
                }
                XMLOutputter xout = new XMLOutputter();
                doc = builder.build(f);
                xout.setFormat(Format.getPrettyFormat());
                OutputStream out = new FileOutputStream(f);
                xout.output(doc, out);
            } catch (JDOMException | IOException e) {
                e.printStackTrace();
            }

        }
    }
}
