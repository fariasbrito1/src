
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Principal {

    public static void main(String[] args) throws JDOMException {

        Scanner tec = new Scanner(System.in);
        Scanner tec2 = new Scanner(System.in);
        int menu;
        int id1;

        System.out.println("Digite o número de ID do ultimo curriculo criado");
        id1 = tec2.nextInt();
        System.out.println("Bem-Vindo, Escolha uma das seguintes opções\n1-Cadastrar novo curriculo\n2-Editar Curriculo\n3-Relatorio/n4-Salvar em arquivo de texto");
        menu = tec.nextInt();

        
        //-CADASTRAR--CADASTRAR--CADASTRAR--CADASTRAR--CADASTRAR--CADASTRAR--CADASTRAR--CADASTRAR--CADASTRAR--CADASTRAR-
        if (menu == 1) {

            XMLOutputter xout = new XMLOutputter();
            Element cv = new Element("cv");
            Element pessoa = new Element("pessoa");
            Element formacao = new Element("Formação");

            id1++;
            //teste
            String ID = Integer.toString(id1);

            Attribute id = new Attribute("id", ID);
            pessoa.setAttribute(id);

            Element dadosPessoais = new Element("DadosPessoais");

            System.out.println("Digite o nome do candidato");
            String nome = tec.next();
            Element nome1 = new Element("Nome");
            nome1.setText(nome);

            System.out.println("Digite o sexo Masculino/Feminino");
            String sexo = tec.next();
            Element sexo1 = new Element("Sexo");
            sexo1.setText(sexo);

            System.out.println("Digite a idade do candidato");
            int idadee = tec.nextInt();
            Element idade1 = new Element("Idade");
            String idade = Integer.toString(idadee);
            idade1.setText(idade);
            dadosPessoais.addContent(nome1);
            dadosPessoais.addContent(sexo1);
            dadosPessoais.addContent(idade1);

            Attribute nivel = new Attribute("Nivel", "Graduacao");
            System.out.println("Nome da Instituição: ");
            String nomei = tec.next();
            Element instituicao = new Element("Instituição");
            Attribute nomeinst = new Attribute("nome", nomei);
            System.out.println("Digite o país da instituição: ");
            String pais1 = tec.next();
            Attribute pais = new Attribute("país", pais1);
            System.out.println("Nome do Curso:");
            String curs = tec.next();
            Element curso = new Element("Curso");
            Attribute nomecurso = new Attribute("curso", curs);
            System.out.println("Digite o ano de inicio do curso:");
            int anoIni = tec.nextInt();
            String anoi = Integer.toString(anoIni);
            Attribute anoInicio = new Attribute("anoIni", anoi);
            System.out.println("Digite o ano previsto de término do curso:");
            int anof = tec.nextInt();
            String anofin = Integer.toString(anof);
            Attribute anoFim = new Attribute("anoFim", anofin);
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
                System.out.println("Nome da Instituição: ");
                nomei = tec.next();
                Element instituicaoM = new Element("Instituição");
                Attribute nomeinstM = new Attribute("nome", nomei);
                System.out.println("Digite o país da instituição: ");
                String paism = tec.next();
                Attribute paisM = new Attribute("país", paism);
                System.out.println("Digite o nome do curso: ");
                curs = tec.next();
                Element cursoM = new Element("Curso");
                Attribute nomecursoM = new Attribute("curso", curs);
                System.out.println("Digite o ano de inicio do curso:");
                anoIni = tec.nextInt();
                anoi = Integer.toString(anoIni);
                Attribute anoInicioM = new Attribute("anoIni", anoi);
                System.out.println("Digite o ano previsto de término do curso:");
                anof = tec.nextInt();
                anofin = Integer.toString(anof);
                Attribute anoFimM = new Attribute("anoFim", anofin);
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
                System.out.println("Digite as informações de formaçã");
                Attribute nivelD = new Attribute("Nivel", "Doutorado");
                System.out.println("Nome da Instituição: ");
                nomei = tec.next();
                Element instituicaoD = new Element("Instituição");
                Attribute nomeinstD = new Attribute("nome", nomei);
                System.out.println("Digite o país da instituição: ");
                pais1 = tec.next();
                Attribute paisD = new Attribute("país", pais1);
                System.out.println("Digite o nome do curso: ");
                curs = tec.next();
                Element cursoD = new Element("Curso");
                Attribute nomecursoD = new Attribute("curso", curs);
                System.out.println("Digite o ano de inicio do curso:");
                anoIni = tec.nextInt();
                anoi = Integer.toString(anoIni);
                Attribute anoInicioD = new Attribute("anoIni", anoi);
                System.out.println("Digite o ano previsto de término do curso:");
                anof = tec.nextInt();
                anofin = Integer.toString(anof);
                Attribute anoFimD = new Attribute("anoFim", anofin);
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
            File f = new File("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
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
        }

        //-EDIÇÃO--EDIÇÃO--EDIÇÃO--EDIÇÃO--EDIÇÃO--EDIÇÃO--EDIÇÃO--EDIÇÃO--EDIÇÃO--EDIÇÃO--EDIÇÃO--EDIÇÃO--EDIÇÃO--EDIÇÃO--EDIÇÃO--EDIÇÃO--EDIÇÃO--EDIÇÃO-
        
        
        
        if (menu == 2) {

            System.out.println("deseja procurar um curriculo por 1-NOME ou por 2-ID ?");
            int opcaobusca = tec.nextInt();
            

            // -EDIÇÃO POR NOME--EDIÇÃO POR NOME--EDIÇÃO POR NOME--EDIÇÃO POR NOME--EDIÇÃO POR NOME--EDIÇÃO POR NOME--EDIÇÃO POR NOME--ED
            
            
            
            if (opcaobusca == 1) {

                System.out.println("deseja adicionar instituição ou curso em: 1-Mestrado ou 2-Doutorado ou 3-Graduando");
                int opcao = tec.nextInt();
                if (opcao == 1) {
                    try {
                        SAXBuilder builder = new SAXBuilder();
                        Document doc = builder.build("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                        Element root = (Element) doc.getRootElement();
                        Element curriculos = null;
                        ArrayList<Element> listacur = (ArrayList<Element>) root.getChildren();
                        System.out.println("Digite o nome do candidato:");
                        String nome = tec.next();
                        for (int i = 0; i < listacur.size(); i++) {
                            curriculos = listacur.get(i);
                            if (curriculos.getChild("DadosPessoais").getChildText("Nome").equalsIgnoreCase(nome)) {
                                System.out.println("deseja adicionar 1-instituição ou 2-curso");
                                int IC = tec2.nextInt();
                                if (IC == 1) {
                                    System.out.println("Nome da Instituição: ");
                                    String nomei = tec.next();
                                    Element instituicaoM = new Element("Instituição");
                                    Attribute nomeinstM = new Attribute("nome", nomei);
                                    instituicaoM.setAttribute(nomeinstM);
                                    curriculos.getChild("Formação").addContent(instituicaoM);
                                    XMLOutputter xout = new XMLOutputter();
                                    xout.setFormat(Format.getPrettyFormat());
                                    OutputStream out = new FileOutputStream("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                                    xout.output(doc, out);
                                    System.out.println("Documento alterado com sucesso!");
                                }

                                if (IC == 2) {
                                    System.out.println("Digite o nome do curso: ");
                                    String curs = tec.next();
                                    Element cursoM = new Element("Curso");
                                    Attribute nomecursoM = new Attribute("curso", curs);
                                    cursoM.setAttribute(nomecursoM);
                                    XMLOutputter xout = new XMLOutputter();
                                    xout.setFormat(Format.getPrettyFormat());
                                    OutputStream out = new FileOutputStream("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                                    xout.output(doc, out);
                                    System.out.println("Documento alterado com sucesso!");

                                }

                            }
                        }

                    } catch (JDOMException | IOException ex) {

                    }
                }

                if (opcao == 2) {
                    try {
                        SAXBuilder builder = new SAXBuilder();
                        Document doc = builder.build("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                        Element root = (Element) doc.getRootElement();
                        Element curriculos = null;
                        ArrayList<Element> listacur = (ArrayList<Element>) root.getChildren();
                        System.out.println("Digite o nome do candidato:");
                        String nome = tec.next();
                        for (int i = 0; i < listacur.size(); i++) {
                            curriculos = listacur.get(i);
                            if (curriculos.getChild("DadosPessoais").getChildText("Nome").equalsIgnoreCase(nome)) {

                                System.out.println("deseja adicionar 1-instituição ou 2-curso");
                                int IC = tec2.nextInt();
                                if (IC == 1) {
                                    System.out.println("Nome da Instituição: ");
                                    String nomei = tec.next();
                                    Element instituicaoD = new Element("Instituição");
                                    Attribute nomeinstD = new Attribute("nome", nomei);
                                    instituicaoD.setAttribute(nomeinstD);
                                    curriculos.getChild("Formação").addContent(instituicaoD);
                                    XMLOutputter xout = new XMLOutputter();
                                    xout.setFormat(Format.getPrettyFormat());
                                    OutputStream out = new FileOutputStream("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                                    xout.output(doc, out);
                                    System.out.println("Documento alterado com sucesso!");
                                }

                                if (IC == 2) {
                                    System.out.println("Digite o nome do curso: ");
                                    String curs = tec.next();
                                    Element cursoD = new Element("Curso");
                                    Attribute nomecursoD = new Attribute("curso", curs);
                                    cursoD.setAttribute(nomecursoD);
                                    XMLOutputter xout = new XMLOutputter();
                                    xout.setFormat(Format.getPrettyFormat());
                                    OutputStream out = new FileOutputStream("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                                    xout.output(doc, out);
                                    System.out.println("Documento alterado com sucesso!");

                                }
                            }
                        }

                    } catch (JDOMException | IOException ex) {

                    }
                    if (opcao == 3) {
                        try {
                            SAXBuilder builder = new SAXBuilder();
                            Document doc = builder.build("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                            Element root = (Element) doc.getRootElement();
                            Element curriculos = null;
                            ArrayList<Element> listacur = (ArrayList<Element>) root.getChildren();
                            System.out.println("Digite o nome do candidato:");
                            String nome = tec.next();
                            for (int i = 0; i < listacur.size(); i++) {
                                curriculos = listacur.get(i);
                                if (curriculos.getChild("DadosPessoais").getChildText("Nome").equalsIgnoreCase(nome)) {

                                    System.out.println("deseja adicionar 1-instituição ou 2-curso");
                                    int IC = tec2.nextInt();
                                    if (IC == 1) {
                                        System.out.println("Nome da Instituição: ");
                                        String nomei = tec.next();
                                        Element instituicao = new Element("Instituição");
                                        Attribute nomeinst = new Attribute("nome", nomei);
                                        instituicao.setAttribute(nomeinst);
                                        curriculos.getChild("Formação").addContent(instituicao);
                                        XMLOutputter xout = new XMLOutputter();
                                        xout.setFormat(Format.getPrettyFormat());
                                        OutputStream out = new FileOutputStream("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                                        xout.output(doc, out);
                                        System.out.println("Documento alterado com sucesso!");
                                    }

                                    if (IC == 2) {
                                        System.out.println("Digite o nome do curso: ");
                                        String curs = tec.next();
                                        Element curso = new Element("Curso");
                                        Attribute nomecurso = new Attribute("curso", curs);
                                        curso.setAttribute(nomecurso);
                                        XMLOutputter xout = new XMLOutputter();
                                        xout.setFormat(Format.getPrettyFormat());
                                        OutputStream out = new FileOutputStream("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                                        xout.output(doc, out);
                                        System.out.println("Documento alterado com sucesso!");

                                    }
                                }
                            }

                        } catch (JDOMException | IOException ex) {

                        }
                    }

                }

            // -EDIÇÃO POR ID--EDIÇÃO POR ID--EDIÇÃO POR ID--EDIÇÃO POR ID--EDIÇÃO POR ID--EDIÇÃO POR ID--EDIÇÃO POR ID--EDIÇÃO POR ID-
                
                
                
                if (opcaobusca == 2) {
                    System.out.println("deseja adicionar instituição ou curso em: 1-Mestrado ou 2-Doutorado ou 3-Graduando");
                    int opcao2 = tec.nextInt();
                    if (opcao2 == 1) {
                        try {
                            SAXBuilder builder = new SAXBuilder();
                            Document doc = builder.build("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                            Element root = (Element) doc.getRootElement();
                            Element curriculos = null;
                            ArrayList<Element> listacur = (ArrayList<Element>) root.getChildren();

                            System.out.println("Digite o ID do candidato:");
                            int buscid = tec.nextInt();
                            String buscaid = Integer.toString(buscid);
                            for (int i = 0; i < listacur.size(); i++) {
                                curriculos = listacur.get(i);
                                if (curriculos.getAttributeValue("id").equalsIgnoreCase(buscaid)) {

                                    System.out.println("deseja adicionar 1-instituição ou 2-curso");
                                    int IC = tec2.nextInt();
                                    if (IC == 1) {
                                        System.out.println("Nome da Instituição: ");
                                        String nomei = tec.next();
                                        Element instituicaoM = new Element("Instituição");
                                        Attribute nomeinstM = new Attribute("nome", nomei);
                                        instituicaoM.setAttribute(nomeinstM);
                                        curriculos.getChild("Formação").addContent(instituicaoM);
                                        XMLOutputter xout = new XMLOutputter();
                                        xout.setFormat(Format.getPrettyFormat());
                                        OutputStream out = new FileOutputStream("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                                        xout.output(doc, out);
                                        System.out.println("Documento alterado com sucesso!");
                                    }

                                    if (IC == 2) {
                                        System.out.println("Digite o nome do curso: ");
                                        String curs = tec.next();
                                        Element cursoM = new Element("Curso");
                                        Attribute nomecursoM = new Attribute("curso", curs);
                                        cursoM.setAttribute(nomecursoM);
                                        XMLOutputter xout = new XMLOutputter();
                                        xout.setFormat(Format.getPrettyFormat());
                                        OutputStream out = new FileOutputStream("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                                        xout.output(doc, out);
                                        System.out.println("Documento alterado com sucesso!");

                                    }
                                }
                            }
                        } catch (IOException ex) {

                        }
                    }

                    if (opcao2 == 2) {
                        try {
                            SAXBuilder builder = new SAXBuilder();
                            Document doc = builder.build("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                            Element root = (Element) doc.getRootElement();
                            Element curriculos = null;
                            ArrayList<Element> listacur = (ArrayList<Element>) root.getChildren();
                            System.out.println("Digite o ID do candidato:");
                            int buscid = tec.nextInt();
                            String buscaid = Integer.toString(buscid);
                            for (int i = 0; i < listacur.size(); i++) {
                                curriculos = listacur.get(i);
                                if (curriculos.getAttributeValue("id").equalsIgnoreCase(buscaid)) {
                                    System.out.println("deseja adicionar 1-instituição ou 2-curso");
                                    int IC = tec2.nextInt();
                                    if (IC == 1) {
                                        System.out.println("Nome da Instituição: ");
                                        String nomei = tec.next();
                                        Element instituicaoD = new Element("Instituição");
                                        Attribute nomeinstD = new Attribute("nome", nomei);
                                        instituicaoD.setAttribute(nomeinstD);
                                        curriculos.getChild("Formação").addContent(instituicaoD);
                                        XMLOutputter xout = new XMLOutputter();
                                        xout.setFormat(Format.getPrettyFormat());
                                        OutputStream out = new FileOutputStream("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                                        xout.output(doc, out);
                                        System.out.println("Documento alterado com sucesso!");
                                    }

                                    if (IC == 2) {
                                        System.out.println("Digite o nome do curso: ");
                                        String curs = tec.next();
                                        Element cursoD = new Element("Curso");
                                        Attribute nomecursoD = new Attribute("curso", curs);
                                        cursoD.setAttribute(nomecursoD);
                                        XMLOutputter xout = new XMLOutputter();
                                        xout.setFormat(Format.getPrettyFormat());
                                        OutputStream out = new FileOutputStream("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                                        xout.output(doc, out);
                                        System.out.println("Documento alterado com sucesso!");

                                    }
                                }
                            }

                        } catch (IOException ex) {

                        }

                    }
                    if (opcao2 == 3) {
                        try {
                            SAXBuilder builder = new SAXBuilder();
                            Document doc = builder.build("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                            Element root = (Element) doc.getRootElement();
                            Element curriculos = null;
                            ArrayList<Element> listacur = (ArrayList<Element>) root.getChildren();
                            System.out.println("Digite o ID do candidato:");
                            int buscid = tec.nextInt();
                            String buscaid = Integer.toString(buscid);
                            for (int i = 0; i < listacur.size(); i++) {
                                curriculos = listacur.get(i);
                                if (curriculos.getAttributeValue("id").equalsIgnoreCase(buscaid)) {
                                    System.out.println("deseja adicionar 1-instituição ou 2-curso");
                                    int IC = tec2.nextInt();
                                    if (IC == 1) {
                                        System.out.println("Nome da Instituição: ");
                                        String nomei = tec.next();
                                        Element instituicao = new Element("Instituição");
                                        Attribute nomeinst = new Attribute("nome", nomei);
                                        instituicao.setAttribute(nomeinst);
                                        curriculos.getChild("Formação").addContent(instituicao);
                                        XMLOutputter xout = new XMLOutputter();
                                        xout.setFormat(Format.getPrettyFormat());
                                        OutputStream out = new FileOutputStream("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                                        xout.output(doc, out);
                                        System.out.println("Documento alterado com sucesso!");
                                    }

                                    if (IC == 2) {
                                        System.out.println("Digite o nome do curso: ");
                                        String curs = tec.next();
                                        Element curso = new Element("Curso");
                                        Attribute nomecurso = new Attribute("curso", curs);
                                        curso.setAttribute(nomecurso);
                                        XMLOutputter xout = new XMLOutputter();
                                        xout.setFormat(Format.getPrettyFormat());
                                        OutputStream out = new FileOutputStream("C:\\Users\\Lucas\\Desktop\\Curriculo.xml");
                                        xout.output(doc, out);
                                        System.out.println("Documento alterado com sucesso!");

                                    }

                                }
                            }

                        } catch (JDOMException | IOException ex) {

                        }
                    }

                }

            }
        }
        
        
        // -relatorio--relatorio--relatorio--relatorio--relatorio--relatorio--relatorio--relatorio--relatorio--relatorio--relatorio-
        
        
        if(menu == 3){
            System.out.println("Selecione qual dos seguintes relatorios deseja visualizar: 1-todas as pessoas que estudaram em uma determinada instituição inserida pelo usuário (nome, sexo, curso)/n2-todos as mulheres que fizeram ou estão fazendo mestrado no Brasil (nome, instituição, curso, status (concluído/em andamento)) /n3-todos os homens que fizeram doutorado no exterior (nome, idade, instituição, curso, ano de término)");
            int relat = tec.nextInt();
            if(relat == 1){}
            if(relat == 2){}
            if(relat == 3){}
            
            
        
        
        
        }
         //-SALVAR ARQUIVO--SALVAR ARQUIVO--SALVAR ARQUIVO--SALVAR ARQUIVO--SALVAR ARQUIVO--SALVAR ARQUIVO--SALVAR ARQUIVO--SALVAR ARQUIVO-
        
        if(menu == 4){
        }
    }
}
