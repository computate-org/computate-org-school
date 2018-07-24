package org.computate.tout.java;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import com.thoughtworks.qdox.model.JavaAnnotation;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaConstructor;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaMember;
import com.thoughtworks.qdox.model.JavaMethod;

public class IndexerClasse extends RegarderClasseBase { 

	public void peuplerClassesSuperQdoxInterfacesEtMoi (
			JavaClass c
			, ArrayList<JavaClass> classesSuperQdox
			, ArrayList<JavaClass> classesSuperQdoxEtMoi
			, ArrayList<JavaClass> classesSuperQdoxEtInterfaces
			, ArrayList<JavaClass> classesSuperQdoxInterfacesEtMoi
			) throws Exception { 
		if(c != null) {
			JavaClass classeSuper = c.getSuperJavaClass();
			List<JavaClass> interfacesImplémentées = c.getInterfaces();
//			JavaConstructor constructeur = c.getConstructor(new ArrayList<JavaType>());
//			if(constructeur != null)
//				constructeursAucunParametresAjouter(constructeur);

			for(JavaClass iface : interfacesImplémentées) {
				if(iface != null && !iface.getCanonicalName().equals("java.lang.Object") && !c.equals(iface)) {
					classesSuperQdoxInterfacesEtMoi.add(iface);
					classesSuperQdoxEtInterfaces.add(classeSuper);
					peuplerClassesSuperQdoxInterfacesEtMoi(iface, classesSuperQdox, classesSuperQdoxEtMoi, classesSuperQdoxEtInterfaces, classesSuperQdoxInterfacesEtMoi); // Doesn't seem to work for interfaces that extend other interfaces.
				}
			}
			classesSuperQdoxEtMoi.add(c);
			if(classeSuper != null && !classeSuper.getCanonicalName().equals("java.lang.Object") && !c.equals(classeSuper)) {
				classesSuperQdoxInterfacesEtMoi.add(classeSuper);
				classesSuperQdoxEtMoi.add(classeSuper);
				classesSuperQdoxEtInterfaces.add(classeSuper);
				classesSuperQdox.add(classeSuper);
				peuplerClassesSuperQdoxInterfacesEtMoi(classeSuper, classesSuperQdox, classesSuperQdoxEtMoi, classesSuperQdoxEtInterfaces, classesSuperQdoxInterfacesEtMoi);
			}
		}
	}
	
	protected Boolean stocker(SolrInputDocument doc, String nomChamp, Boolean valeurChamp) throws Exception {
		doc.addField(concat(nomChamp, "_stocke_string"), valeurChamp);
		return valeurChamp;
	}
	
	protected Boolean stocker(SolrInputDocument doc, String nomChamp, String nomLangue, Boolean valeurChamp) throws Exception {
		doc.addField(concat(nomChamp, "_", nomLangue, "_stocke_string"), valeurChamp);
		return valeurChamp;
	}
	
	protected String stocker(SolrInputDocument doc, String nomChamp, String valeurChamp) throws Exception {
		doc.addField(concat(nomChamp, "_stocke_string"), valeurChamp);
		return valeurChamp;
	}
	
	protected String stocker(SolrInputDocument doc, String nomChamp, String nomLangue, String valeurChamp) throws Exception {
		doc.addField(concat(nomChamp, "_", nomLangue, "_stocke_string"), valeurChamp);
		return valeurChamp;
	}
	
	protected Boolean indexer(SolrInputDocument doc, String nomChamp, Boolean valeurChamp) throws Exception {
		doc.addField(concat(nomChamp, "_indexe_string"), valeurChamp);
		return valeurChamp;
	} 
	
	protected Boolean indexer(SolrInputDocument doc, String nomChamp, String nomLangue, Boolean valeurChamp) throws Exception {
		doc.addField(concat(nomChamp, "_", nomLangue, "_indexe_string"), valeurChamp);
		return valeurChamp;
	}
	
	protected String indexer(SolrInputDocument doc, String nomChamp, String valeurChamp) throws Exception {
		doc.addField(concat(nomChamp, "_indexe_string"), valeurChamp);
		return valeurChamp;
	}
	
	protected String indexer(SolrInputDocument doc, String nomChamp, String nomLangue, String valeurChamp) throws Exception {
		doc.addField(concat(nomChamp, "_", nomLangue, "_indexe_string"), valeurChamp);
		return valeurChamp;
	}
	
	protected Long indexerStocker(SolrInputDocument doc, String nomChamp, Long valeurChamp) throws Exception {
		doc.addField(concat(nomChamp, "_stocke_long"), valeurChamp);
		doc.addField(concat(nomChamp, "_indexe_long"), valeurChamp);
		return valeurChamp;
	}
	
	protected Integer indexerStocker(SolrInputDocument doc, String nomChamp, Integer valeurChamp) throws Exception {
		doc.addField(concat(nomChamp, "_stocke_int"), valeurChamp);
		doc.addField(concat(nomChamp, "_indexe_int"), valeurChamp);
		return valeurChamp;
	}
	
	protected Boolean indexerStocker(SolrInputDocument doc, String nomChamp, Boolean valeurChamp) throws Exception {
		doc.addField(concat(nomChamp, "_stocke_boolean"), valeurChamp);
		doc.addField(concat(nomChamp, "_indexe_boolean"), valeurChamp);
		return valeurChamp;
	}
	
	protected Boolean indexerStocker(SolrInputDocument doc, String nomChamp, String nomLangue, Boolean valeurChamp) throws Exception {
		doc.addField(concat(nomChamp, "_", nomLangue, "_stocke_string"), valeurChamp);
		doc.addField(concat(nomChamp, "_", nomLangue, "_indexe_string"), valeurChamp);
		return valeurChamp;
	}
	
	protected String indexerStocker(SolrInputDocument doc, String nomChamp, String valeurChamp) throws Exception {
		doc.addField(concat(nomChamp, "_stocke_string"), valeurChamp);
		doc.addField(concat(nomChamp, "_indexe_string"), valeurChamp);
		return valeurChamp;
	}
	
	protected String indexerStocker(SolrInputDocument doc, String nomChamp, String nomLangue, String valeurChamp) throws Exception {
		doc.addField(concat(nomChamp, "_", nomLangue, "_stocke_string"), valeurChamp);
		doc.addField(concat(nomChamp, "_", nomLangue, "_indexe_string"), valeurChamp);
		return valeurChamp;
	}

	protected void indexerClasse(String classeCheminAbsolu) throws Exception { 
		SolrInputDocument classeDoc = new SolrInputDocument();
		String classeNomCanonique = StringUtils.replace(StringUtils.substringAfter(StringUtils.substringBeforeLast(classeCheminAbsolu, "."), cheminSrcMainJava + "/"), "/", ".");
		String classeNomSimple = StringUtils.substringAfterLast(classeNomCanonique, ".");
		String classeNomCanoniqueGen = classeNomCanonique + "Gen";
		String classeNomSimpleGen = classeNomSimple + "Gen";
		JavaClass classeQdoxClasse = bricoleur.getClassByName(classeNomCanonique.toString());
		JavaClass classeQdoxSuper = classeQdoxClasse.getSuperJavaClass();
		String classeNomCanoniqueSuper = classeQdoxSuper.getCanonicalName();
		String classeNomSimpleSuper = StringUtils.substringAfterLast(classeNomCanoniqueSuper, ".");
		String commentaire = classeQdoxClasse.getComment();
		String classeNomEnsemble = StringUtils.substringBeforeLast(classeNomCanonique, ".");
		String classeChemin = concat(cheminSrcMainJava, "/", StringUtils.replace(classeNomCanonique, ".", "/"), ".java");
		String classeCheminRepertoire = StringUtils.substringBeforeLast(classeChemin, "/");
		String classeCheminGen = concat(cheminSrcGenJava, "/", StringUtils.replace(classeNomCanonique, ".", "/"), "Gen.java");
		String classeCheminRepertoireGen = StringUtils.substringBeforeLast(classeCheminGen, "/");
		String cleClasse = classeChemin;
		Instant modifiee = Instant.now();
		Date modifieeDate = Date.from(modifiee);
		
		ArrayList<JavaClass> classesSuperQdox = new ArrayList<JavaClass>();
		ArrayList<JavaClass> classesSuperQdoxEtMoi = new ArrayList<JavaClass>();
		classesSuperQdoxEtMoi.add(classeQdoxClasse);
		ArrayList<JavaClass> classesSuperQdoxEtInterfaces = new ArrayList<JavaClass>();
		ArrayList<JavaClass> classesSuperQdoxInterfacesEtMoi = new ArrayList<JavaClass>();
		classesSuperQdoxInterfacesEtMoi.add(classeQdoxClasse);
		peuplerClassesSuperQdoxInterfacesEtMoi(classeQdoxClasse, classesSuperQdox, classesSuperQdoxEtMoi, classesSuperQdoxEtInterfaces, classesSuperQdoxInterfacesEtMoi);

		indexerStocker(classeDoc, "nomLangue", nomLangue); 
		classeDoc.addField("modifiee_indexe_date", modifieeDate); 
		classeDoc.addField("modifiee_stocke_date", modifieeDate);

		classeDoc.addField(concat("classeNomCanonique_", nomLangue, "_indexe_string"), classeNomCanonique);
		classeDoc.addField(concat("classeNomCanonique_", nomLangue, "_stocke_string"), classeNomCanonique);

		classeDoc.addField(concat("classeNomSimple_", nomLangue, "_indexe_string"), classeNomSimple);
		classeDoc.addField(concat("classeNomSimple_", nomLangue, "_stocke_string"), classeNomSimple);

		classeDoc.addField(concat("classeNomEnsemble_", nomLangue, "_indexe_string"), classeNomEnsemble);
		classeDoc.addField(concat("classeNomEnsemble_", nomLangue, "_stocke_string"), classeNomEnsemble);

		classeDoc.addField(concat("classeNomCanoniqueGen_", nomLangue, "_indexe_string"), classeNomCanoniqueGen);
		classeDoc.addField(concat("classeNomCanoniqueGen_", nomLangue, "_stocke_string"), classeNomCanoniqueGen);

		classeDoc.addField(concat("classeNomSimpleGen_", nomLangue, "_indexe_string"), classeNomSimpleGen);
		classeDoc.addField(concat("classeNomSimpleGen_", nomLangue, "_stocke_string"), classeNomSimpleGen);

		classeDoc.addField(concat("classeNomCanoniqueSuper_", nomLangue, "_indexe_string"), classeNomCanoniqueSuper);
		classeDoc.addField(concat("classeNomCanoniqueSuper_", nomLangue, "_stocke_string"), classeNomCanoniqueSuper);

		classeDoc.addField(concat("classeNomSimpleSuper_", nomLangue, "_indexe_string"), classeNomSimpleSuper);
		classeDoc.addField(concat("classeNomSimpleSuper_", nomLangue, "_stocke_string"), classeNomSimpleSuper);

		classeDoc.addField(concat("classeCheminAbsolu_indexe_string"), classeCheminAbsolu);
		classeDoc.addField(concat("classeCheminAbsolu_stocke_string"), classeCheminAbsolu);

		classeDoc.addField(concat("classeChemin_", nomLangue, "_indexe_string"), classeChemin);
		classeDoc.addField(concat("classeChemin_", nomLangue, "_stocke_string"), classeChemin);

		classeDoc.addField(concat("classeCheminRepertoire_", nomLangue, "_indexe_string"), classeCheminRepertoire);
		classeDoc.addField(concat("classeCheminRepertoire_", nomLangue, "_stocke_string"), classeCheminRepertoire);

		classeDoc.addField(concat("classeCheminGen_", nomLangue, "_indexe_string"), classeCheminGen);
		classeDoc.addField(concat("classeCheminGen_", nomLangue, "_stocke_string"), classeCheminGen);

		classeDoc.addField(concat("classeCheminRepertoireGen_", nomLangue, "_indexe_string"), classeCheminRepertoireGen);
		classeDoc.addField(concat("classeCheminRepertoireGen_", nomLangue, "_stocke_string"), classeCheminRepertoireGen);

		for(String nomLangue : autresLangues) {  
			String classeNomCanoniqueLangue = regex("classeNomCanonique\\." + nomLangue + ": (.*)", commentaire);
			String classeNomSimpleLangue = StringUtils.substringAfterLast(classeNomCanoniqueLangue, ".") + "Gen";
			String classeNomEnsembleLangue = StringUtils.substringBeforeLast(classeNomCanoniqueLangue, ".");
			String classeNomCanoniqueGenLangue = classeNomCanoniqueLangue + "Gen";
			String classeNomSimpleGenLangue = classeNomSimpleLangue + "Gen";
			String classeCheminLangue = concat(cheminSrcMainJava, "/", StringUtils.replace(classeNomCanoniqueLangue, ".", "/"), ".java");
			String classeCheminRepertoireLangue = StringUtils.substringBeforeLast(classeCheminLangue, "/");
			String classeCheminGenLangue = concat(cheminSrcGenJava, "/", StringUtils.replace(classeNomCanoniqueLangue, ".", "/"), ".java");
			String classeCheminRepertoireGenLangue = StringUtils.substringBeforeLast(classeCheminGenLangue, "/");

			classeDoc.addField(concat("classeNomCanonique_", nomLangue, "_indexe_string"), classeNomCanoniqueLangue);
			classeDoc.addField(concat("classeNomCanonique_", nomLangue, "_stocke_string"), classeNomCanoniqueLangue);

			classeDoc.addField(concat("classeNomSimple_", nomLangue, "_indexe_string"), classeNomSimpleLangue);
			classeDoc.addField(concat("classeNomSimple_", nomLangue, "_stocke_string"), classeNomSimpleLangue);

			classeDoc.addField(concat("classeNomCanoniqueGen_", nomLangue, "_indexe_string"), classeNomCanoniqueGenLangue);
			classeDoc.addField(concat("classeNomCanoniqueGen_", nomLangue, "_stocke_string"), classeNomCanoniqueGenLangue);

			classeDoc.addField(concat("classeNomSimpleGen_", nomLangue, "_indexe_string"), classeNomSimpleGenLangue);
			classeDoc.addField(concat("classeNomSimpleGen_", nomLangue, "_stocke_string"), classeNomSimpleGenLangue);

			classeDoc.addField(concat("classeNomEnsemble_", nomLangue, "_indexe_string"), classeNomEnsembleLangue);
			classeDoc.addField(concat("classeNomEnsemble_", nomLangue, "_stocke_string"), classeNomEnsembleLangue);

			classeDoc.addField(concat("classeChemin_", nomLangue, "_indexe_string"), classeCheminLangue);
			classeDoc.addField(concat("classeChemin_", nomLangue, "_stocke_string"), classeCheminLangue);

			classeDoc.addField(concat("classeCheminRepertoire_", nomLangue, "_indexe_string"), classeCheminRepertoireLangue);
			classeDoc.addField(concat("classeCheminRepertoire_", nomLangue, "_stocke_string"), classeCheminRepertoireLangue);

			classeDoc.addField(concat("classeCheminGen_", nomLangue, "_indexe_string"), classeCheminGenLangue);
			classeDoc.addField(concat("classeCheminGen_", nomLangue, "_stocke_string"), classeCheminGenLangue);

			classeDoc.addField(concat("classeCheminRepertoireGen_", nomLangue, "_indexe_string"), classeCheminRepertoireGenLangue);
			classeDoc.addField(concat("classeCheminRepertoireGen_", nomLangue, "_stocke_string"), classeCheminRepertoireGenLangue);
		} 

		SolrInputDocument docClasseClone = classeDoc.deepCopy();
		Integer partNumero = 1;

		classeDoc.addField("cle", cleClasse);  

		indexerStocker(classeDoc, "partEstClasse", true);
		indexerStocker(classeDoc, "partNumero", partNumero);

		List<JavaMember> membresQdox = new ArrayList<JavaMember>();
		membresQdox.addAll(classeQdoxClasse.getFields());
		membresQdox.addAll(classeQdoxClasse.getConstructors());
		membresQdox.addAll(classeQdoxClasse.getMethods());
		for(JavaMember membreQdox : membresQdox) {  
			partNumero++;

			if(membreQdox instanceof JavaField) {    
				SolrInputDocument champDoc = docClasseClone.deepCopy();
				JavaField champQdox = (JavaField)membreQdox;
				JavaClass champClasseQdox = champQdox.getType();
				String champCommentaire = champQdox.getComment();
				String champVar = champQdox.getName();
				String champNomCanonique = champQdox.getType().getCanonicalName();
				String nomTypeOrigine = champClasseQdox.getGenericCanonicalName();
				String listeNomTypeOrigineGenerique = nomTypeOrigine;
				String champNomCanoniqueGenerique = StringUtils.substringBeforeLast(StringUtils.substringAfter(listeNomTypeOrigineGenerique, "<"), ">");
				champNomCanoniqueGenerique = champNomCanoniqueGenerique.contains("<") ? StringUtils.substringBefore(champNomCanoniqueGenerique, "<") : champNomCanoniqueGenerique;
				champNomCanoniqueGenerique = champNomCanoniqueGenerique.contains(",") ? StringUtils.substringBefore(champNomCanoniqueGenerique, ",") : champNomCanoniqueGenerique;
				String champCle = classeChemin + "." + champVar;

				// Champs Solr du champ. 

				champDoc.addField("cle", champCle);

				champDoc.addField(concat("champVar_", nomLangue, "_indexe_string"), champVar);
				champDoc.addField(concat("champVar_", nomLangue, "_stocke_string"), champVar);

				indexerStocker(champDoc, "partEstChamp", true);
				indexerStocker(champDoc, "partNumero", partNumero);

				champDoc.addField(concat("champEstPublic_indexe_boolean"), champQdox.isPublic());   
				champDoc.addField(concat("champEstPublic_stocke_boolean"), champQdox.isPublic());

				champDoc.addField(concat("champEstProtege_indexe_boolean"), champQdox.isProtected());
				champDoc.addField(concat("champEstProtege_stocke_boolean"), champQdox.isProtected());

				champDoc.addField(concat("champEstPrive_indexe_boolean"), champQdox.isPrivate());
				champDoc.addField(concat("champEstPrive_stocke_boolean"), champQdox.isPrivate());

				champDoc.addField(concat("champEstStatique_indexe_boolean"), champQdox.isStatic());
				champDoc.addField(concat("champEstStatique_stocke_boolean"), champQdox.isStatic());

				champDoc.addField(concat("champEstFinale_indexe_boolean"), champQdox.isFinal());
				champDoc.addField(concat("champEstFinale_stocke_boolean"), champQdox.isFinal());

				champDoc.addField(concat("champEstAbstrait_indexe_boolean"), champQdox.isAbstract());
				champDoc.addField(concat("champEstAbstrait_stocke_boolean"), champQdox.isAbstract());

				champDoc.addField(concat("champEstNatif_indexe_boolean"), champQdox.isNative());
				champDoc.addField(concat("champEstNatif_stocke_boolean"), champQdox.isNative());
	
				///////////////////////
				// Champ Annotations //
				///////////////////////
				List<JavaAnnotation> annotations = champQdox.getAnnotations(); 
				ArrayList<String> annotationsLangue = new ArrayList<String>();
				Boolean champEstTest = false;
				Boolean champEstSubstitue = false;
				for(JavaAnnotation annotation : annotations) {
					String champAnnotationLangue = annotation.getType().getCanonicalName();

					champDoc.addField(concat("champAnnotations_", nomLangue, "_indexe_string"), champAnnotationLangue);
					champDoc.addField(concat("champAnnotations_", nomLangue, "_stocke_string"), champAnnotationLangue);

					if("org.junit.Test".equals(annotation.getType().getCanonicalName())) {
						champEstTest = true;
					}
					if("java.lang.Override".equals(annotation.getType().getCanonicalName())) {
						champEstSubstitue = true;
					}
				}

				champDoc.addField(concat("champEstTest_indexe_boolean"), champEstTest);
				champDoc.addField(concat("champEstTest_stocke_boolean"), champEstTest);

				champDoc.addField(concat("champEstSubstitue_indexe_boolean"), champEstSubstitue);
				champDoc.addField(concat("champEstSubstitue_stocke_boolean"), champEstSubstitue);
	
				//////////////////
				// Champ Langue //
				//////////////////
				for(String nomLangue : autresLangues) {  

					String champVarLangue = regex("var\\." + nomLangue + ": (.*)", champCommentaire);
					champVarLangue = champVarLangue == null ? champVar : champVarLangue;
					champDoc.addField(concat("champVar_", nomLangue, "_indexe_string"), champVarLangue);
					champDoc.addField(concat("champVar_", nomLangue, "_stocke_string"), champVarLangue);

					List<String> champCommentairesLangue = regexListe("(.*)", champCommentaire);
					String champCommentaireLangue = StringUtils.join(champCommentairesLangue, "\n");
					champDoc.addField(concat("champCommentaire_", nomLangue, "_indexe_string"), champCommentaireLangue);
					champDoc.addField(concat("champCommentaire_", nomLangue, "_stocke_string"), champCommentaireLangue);

					String champBlocCode = champQdox.getCodeBlock();
					String champBlocCodeLangue = champBlocCode;
					ArrayList<String> remplacerClesLangue = regexListe("^r." + nomLangue + "\\s*=\\s*(.*)\\n.*", champCommentaire);
					ArrayList<String> remplacerValeursLangue = regexListe("^r." + nomLangue + "\\s*=\\s*.*\\n(.*)", champCommentaire);
					for(int i = 0; i < remplacerClesLangue.size(); i++) {
						String cle = remplacerClesLangue.get(i);
						String valeur = remplacerValeursLangue.get(i);
						StringUtils.replace(champBlocCodeLangue, cle, valeur);
					}
					champDoc.addField(concat("champBlocCode_", nomLangue, "_indexe_string"), champBlocCodeLangue);
					champDoc.addField(concat("champBlocCode_", nomLangue, "_stocke_string"), champBlocCodeLangue);
				}  

				clientSolr.add(champDoc); 
			}
			else if(membreQdox instanceof JavaConstructor) { 
				SolrInputDocument constructeurDoc = docClasseClone.deepCopy();
				JavaConstructor constructeurQdox = (JavaConstructor)membreQdox;
//				JavaClass champClasseQdox = constructeurQdox.getType();
//				String constructeurCle = classeChemin + "." + constructeurVar;
//
//				constructeurDoc.addField("cle", constructeurCle);

				classeDoc.addField(concat("constructeurEstConstructeur_indexe_boolean"), true);
				classeDoc.addField(concat("constructeurEstConstructeur_stocke_boolean"), true);

				constructeurDoc.addField(concat("constructeurEstPublic_indexe_boolean"), constructeurQdox.isPublic());
				constructeurDoc.addField(concat("constructeurEstPublic_stocke_boolean"), constructeurQdox.isPublic());

				constructeurDoc.addField(concat("constructeurEstProtege_indexe_boolean"), constructeurQdox.isProtected());
				constructeurDoc.addField(concat("constructeurEstProtege_stocke_boolean"), constructeurQdox.isProtected());

				constructeurDoc.addField(concat("constructeurEstPrive_indexe_boolean"), constructeurQdox.isPrivate());
				constructeurDoc.addField(concat("constructeurEstPrive_stocke_boolean"), constructeurQdox.isPrivate());

				constructeurDoc.addField(concat("constructeurEstStatique_indexe_boolean"), constructeurQdox.isStatic());
				constructeurDoc.addField(concat("constructeurEstStatique_stocke_boolean"), constructeurQdox.isStatic());

				constructeurDoc.addField(concat("constructeurEstFinale_indexe_boolean"), constructeurQdox.isFinal());
				constructeurDoc.addField(concat("constructeurEstFinale_stocke_boolean"), constructeurQdox.isFinal());

				constructeurDoc.addField(concat("constructeurEstAbstrait_indexe_boolean"), constructeurQdox.isAbstract());
				constructeurDoc.addField(concat("constructeurEstAbstrait_stocke_boolean"), constructeurQdox.isAbstract());

				constructeurDoc.addField(concat("constructeurEstNatif_indexe_boolean"), constructeurQdox.isNative());
				constructeurDoc.addField(concat("constructeurEstNatif_stocke_boolean"), constructeurQdox.isNative());



//				UnConstructeur constructeur = new UnConstructeur();
//				constructeur.requeteSite(requeteSite);
//				constructeur.constructeurQdox(constructeurQdox);
//				constructeur.constructeurEstPublic(constructeurQdox.isPublic());
//				constructeur.constructeurEstProtege(constructeurQdox.isProtected());
//				constructeur.constructeurEstPrive(constructeurQdox.isPrivate());
//				constructeur.constructeurEstStatique(constructeurQdox.isStatic());
//				constructeur.constructeurEstFinale(constructeurQdox.isFinal());
//				JavaClass classeQdoxConstructeur = constructeurQdox.getDeclaringClass();
//				constructeur.nomConstructeur(constructeurQdox.getName());
//				regexCommentaires(constructeurQdox.getComment(), constructeur.commentaire);
//				regexRemplacerTout(constructeurQdox.getComment(), constructeurQdox.getSourceCode(), constructeur.codeSource);
//				List<JavaAnnotation> annotations = constructeurQdox.getAnnotations();
//				for(JavaAnnotation annotation : annotations) {
//				}
//				constructeur.classe_(this);
//				constructeur.initialiserLoinUnConstructeur(requeteSite);
//				tout.add(constructeur);
			}
			else if(membreQdox instanceof JavaMethod) {
				JavaMethod methodeQdox = (JavaMethod)membreQdox;
				String methodeCommentaire = methodeQdox.getComment();
				Boolean ignorer = "true".equals(regex("ignorer: (.*)", methodeCommentaire));
				if(!ignorer) {
					JavaClass methodeClasseQdoxRetour = methodeQdox.getReturns();
					String methodeNomCanoniqueRetourComplet = null;
					String methodeNomCanoniqueRetour = null;
					JavaClass classeQdoxRetour = methodeQdox.getReturns();
		
					///////////////////////
					// Methode Annotations //
					///////////////////////
					List<JavaAnnotation> annotations = methodeQdox.getAnnotations(); 
					ArrayList<String> annotationsLangue = new ArrayList<String>();
					Boolean methodeEstTest = false;
					Boolean methodeEstSubstitue = false;
					String methodeVar = methodeQdox.getName();
					for(JavaAnnotation annotation : annotations) {
						String methodeAnnotationLangue = annotation.getType().getCanonicalName();
	
						if("org.junit.Test".equals(annotation.getType().getCanonicalName())) {
							methodeEstTest = true;
						}
						if("java.lang.Override".equals(annotation.getType().getCanonicalName())) {
							methodeEstSubstitue = true;
						}
					}
	
					if(!methodeEstSubstitue && !methodeQdox.isStatic() && !methodeQdox.isFinal() && methodeQdox.getDeclaringClass().equals(classeQdoxClasse) 
							&& methodeQdox.isProtected() && methodeQdox.getParameters().size() == 1 && classeQdoxRetour.isVoid()
							&& StringUtils.startsWith(methodeQdox.getName(), "_")) {
						// est Entite. 
						SolrInputDocument entiteDoc = docClasseClone.deepCopy();
						String entiteVar = indexerStocker(entiteDoc, "entiteVar", nomLangue, StringUtils.substringAfter(methodeQdox.getName(), "_"));
						JavaClass entiteClasseQdox = methodeQdox.getParameters().get(0).getJavaClass();
						boolean entiteCouverture = false;
						String entiteNomCanonique = indexerStocker(entiteDoc, "entiteNomCanonique", nomLangue, entiteClasseQdox.getCanonicalName());

						String entiteNomSimple;
						if(entiteNomCanonique.contains("."))
							entiteNomSimple = StringUtils.substringBefore(StringUtils.substringAfterLast(entiteNomCanonique, "."), ">");
						else
							entiteNomSimple = StringUtils.substringBefore(entiteNomCanonique.toString(), ">");
						indexerStocker(entiteDoc, "entiteNomSimple", nomLangue, entiteNomSimple);

						String entiteTypeOrigine = indexerStocker(entiteDoc, "entiteTypeOrigine", nomLangue, entiteClasseQdox.getGenericCanonicalName());

						String entiteNomCompletGenerique = StringUtils.substringBeforeLast(StringUtils.substringAfter(entiteTypeOrigine, "<"), ">");
						String entiteNomCanoniqueGenerique = null;
						JavaClass entiteClasseGeneriqueQdox = null;
						String entiteNomSimpleGenerique = null;
						if(StringUtils.isNotEmpty(entiteNomCompletGenerique)) {
							indexerStocker(entiteDoc, "entiteNomCompletGenerique", nomLangue, entiteNomCompletGenerique);
							entiteNomCanoniqueGenerique = entiteNomCompletGenerique.contains("<") ? StringUtils.substringBefore(entiteNomCompletGenerique, "<") : entiteNomCompletGenerique;
							entiteNomCanoniqueGenerique = entiteNomCompletGenerique.contains(",") ? StringUtils.substringBefore(entiteNomCompletGenerique, ",") : entiteNomCompletGenerique;
							if(StringUtils.isNotEmpty(entiteNomCanoniqueGenerique)) {
								indexerStocker(entiteDoc, "entiteNomCanoniqueGenerique", nomLangue, entiteNomCanoniqueGenerique);
								entiteClasseGeneriqueQdox = bricoleur.getClassByName(entiteNomCanoniqueGenerique);
	//							String nomCanoniqueGeneriqueEnUS = classe_.regex("nomCanonique.enUS:\\s*(.*)", commentaire, 1);
	//							o.enUS(StringUtils.isEmpty(nomCanoniqueGeneriqueEnUS) ? o.frFR() : nomCanoniqueGeneriqueEnUS);
	//							if(nomCanoniqueGenerique.frFR().contains(".")) {
	//								classe_.importationsAjouter(nomCanoniqueGenerique);
	//								classe_.importationsGenAjouter(nomCanoniqueGenerique);
	//							}
	
								if(entiteNomCanoniqueGenerique.contains("."))
									entiteNomSimpleGenerique = StringUtils.substringAfterLast(entiteNomCanoniqueGenerique, ".");
								else
									entiteNomSimpleGenerique = entiteNomCanoniqueGenerique;
								indexerStocker(entiteDoc, "entiteNomSimpleGenerique", nomLangue, entiteNomSimpleGenerique);
							}
						}
						
						String entiteNomCanoniqueComplet;
						if(StringUtils.isNotEmpty(entiteNomCompletGenerique))
							entiteNomCanoniqueComplet = entiteNomCanonique + "<" + entiteNomCompletGenerique + ">";
						else
							entiteNomCanoniqueComplet = entiteNomCanonique;
						indexerStocker(entiteDoc, "entiteNomCanoniqueComplet", nomLangue, entiteNomCanoniqueComplet);
						
						String entiteNomSimpleComplet = entiteNomSimple;
						if(StringUtils.isNotEmpty(entiteNomCompletGenerique)) {
							entiteNomSimpleComplet += "<";
							if(entiteNomCompletGenerique.contains(".")) {
								entiteNomSimpleComplet += StringUtils.substringAfterLast(entiteNomCompletGenerique, ".");
							}
							else {
								entiteNomSimpleComplet += entiteNomCompletGenerique;
							}
							entiteNomSimpleComplet += ">";
						}
						indexerStocker(entiteDoc, "entiteNomSimpleComplet", nomLangue, entiteNomSimpleComplet);
						
						String entiteNomSimpleCompletGenerique = null;
						if(StringUtils.isNotEmpty(entiteNomCompletGenerique)) {
							if(entiteNomCompletGenerique.contains(".")) {
								entiteNomSimpleCompletGenerique = StringUtils.substringAfterLast(entiteNomCompletGenerique, ".");
							}
							else {
								entiteNomSimpleCompletGenerique = entiteNomCompletGenerique;
							}
						}
						indexerStocker(entiteDoc, "entiteNomSimpleCompletGenerique", nomLangue, entiteNomSimpleCompletGenerique);
						
						JavaClass entiteClasseQdoxBase = null;
						JavaClass entiteClasseSuperQdox = entiteClasseQdox.getSuperJavaClass();
						if(entiteClasseSuperQdox != null) {
							String entiteNomCanoniqueSuperQdox = entiteClasseSuperQdox.getCanonicalName();
							if(entiteNomCanoniqueSuperQdox.endsWith("Gen")) {
								entiteClasseQdoxBase = entiteClasseSuperQdox.getSuperJavaClass();
							}
						}
						
						String entiteNomCanoniqueBase = null;
						if(entiteClasseQdoxBase != null) {
							String s = entiteClasseQdoxBase.getCanonicalName();
							if(s.contains("."))
								entiteNomCanoniqueBase = s;
						}
						indexerStocker(entiteDoc, "entiteNomCanoniqueBase", nomLangue, entiteNomCanoniqueBase);
						
						String entiteNomSimpleBase = null;
						if(StringUtils.isNotEmpty(entiteNomCanoniqueBase)) {
							entiteNomSimpleBase = StringUtils.substringAfterLast(entiteNomCanoniqueBase, ".");
						}
						indexerStocker(entiteDoc, "entiteNomSimpleBase", nomLangue, entiteNomSimpleBase);
						
						String entiteVarParam;
						if(entiteNomCanonique.equals(ArrayList.class.getCanonicalName()) || entiteNomCanonique.equals(List.class.getCanonicalName()))
							entiteVarParam = "l";
						else
							entiteVarParam = "o";
						indexerStocker(entiteDoc, "entiteVarParam", nomLangue, entiteVarParam);
						
						String entiteVarCouverture = indexerStocker(entiteDoc, "entiteVarCouverture", nomLangue, entiteVar + "Couverture");
//						boolean entiteCouverture = false;
//	
//						String varEntiteEnUS = regex("^var.enUS: (.*)", methodeQdox.getComment());
//						entite.var.frFR(entiteVar);
//						entite.var.enUS(StringUtils.isEmpty(varEntiteEnUS) ? entiteVar : StringUtils.substringAfter(varEntiteEnUS, "_"));
//	
//						regexCommentaires(methodeQdox.getComment(), entite.commentaire);
//						regexRemplacerTout(methodeQdox.getComment(), methodeQdox.getSourceCode(), entite.codeSource);
//			
//						if(entiteClasseQdox.getFullyQualifiedName().equals(nomCanoniqueCouvertureActuel)) {
//							entiteType = StringUtils.substringBeforeLast(StringUtils.substringAfter(entiteType, "<"), ">");
//							if(StringUtils.contains(entiteType, "<"))
//								entiteClasseQdox = typeBricoleur.getClassByName(StringUtils.substringBefore(entiteType, "<"));
//							else
//								entiteClasseQdox = typeBricoleur.getClassByName(entiteType);
//							entiteNomCanonique = entiteClasseQdox.getCanonicalName();
//							entiteCouverture = true;
//							entite.couverture(true);
//						} 
//						if(entite.cleUnique)
//							varCleUniqueActuel.tout(entite.var);
//						if(entite.suggere)
//							varSuggereActuel.tout(entite.var);
//	
//						if(!entitesTout.contains(entite))
//							entitesTout.add(entite);
//	
//						tout.add(entite);
//						importationsAjouter(new Chaine().tout(entiteNomCanonique));
//						importationsGenAjouter(new Chaine().tout(entiteNomCanonique));
//						if(entiteListeTypeGenerique != null) {
//							Chaine importation = new Chaine().tout(entiteListeTypeGenerique);
//							importationsAjouter(importation);
//							importationsGenAjouter(importation);
//						}
//	
//						boolean etendCluster = etendClasse(entiteNomCanoniqueClusterActuel);
//						entite.etendCluster(etendCluster);
//						if(!etendCluster && entite.nomCanoniqueGenerique.pasVide()) {
//							boolean listeCluster = etendClasse(nomCanoniqueClusterActuel, entite.nomCanoniqueGenerique.toString());
//							entite.listeCluster(listeCluster);
//						}
//	
//						boolean etendPageXml = entite.etendClasse(nomCanoniquePageXmlActuel);
//						entite.etendPageXml(etendPageXml);
//						if(!etendPageXml && entite.nomCanoniqueGenerique.pasVide()) {
//							boolean listePageXml = etendClasse(nomCanoniquePageXmlActuel, entite.nomCanoniqueGenerique.toString());
//							entite.listePageXml(listePageXml);
//						}
//	
//						boolean etendPageParti = entite.etendClasse(nomCanoniquePagePartiActuel);
//						entite.etendPageParti(etendPageParti);
//						if(!etendPageParti && entite.nomCanoniqueGenerique.pasVide()) {
//							boolean listePageParti = etendClasse(nomCanoniquePagePartiActuel, entite.nomCanoniqueGenerique.toString());
//							entite.listePageParti(listePageParti);
//						}
//	
//	
//						boolean contientRequeteSite = contientChamp(varRequeteSite.toString(), entite.classeQdox);
//						entite.contientRequeteSite(contientRequeteSite);
//	
//						boolean contientSetterString = contientMethode(entite.var.toString(), classeQdoxString);
//						entite.contientSetterString(contientSetterString);
//	
//						entiteEstCmd(entite);
						
						
						
						
						
						
						
						
						
						
						
						
						
						indexerStocker(entiteDoc, "entiteVar", nomLangue, entiteVar);
						for(JavaAnnotation annotation : annotations) {
							String entiteAnnotationLangue = indexerStocker(entiteDoc, "entiteAnnotations", nomLangue, annotation.getType().getCanonicalName());
						}
//						if(classeQdoxRetour != null && !classeQdoxRetour.getCanonicalName().equals("void")) {
//							entiteNomCanoniqueRetourComplet = indexerStocker(entiteDoc, "entiteNomCanoniqueRetourComplet", nomLangue, classeQdoxRetour.getGenericCanonicalName());
//							entiteNomCanoniqueRetour = indexerStocker(entiteDoc, "entiteNomCanoniqueRetour", nomLangue, classeQdoxRetour.getCanonicalName());
//							String entiteNomSimpleRetour = indexerStocker(entiteDoc, "entiteNomSimpleRetour", nomLangue, StringUtils.substringAfterLast(entiteNomCanoniqueRetour, "."));
//							String listeNomTypeOrigineRetourGenerique = entiteNomCanoniqueRetourComplet;
//							String entiteNomCanoniqueRetourGenerique = StringUtils.substringBeforeLast(StringUtils.substringAfter(listeNomTypeOrigineRetourGenerique, "<"), ">");
//							String entiteNomSimpleRetourComplet;
//							String entiteNomSimpleRetourGenerique;
//							entiteNomCanoniqueRetourGenerique = entiteNomCanoniqueRetourGenerique.contains("<") ? StringUtils.substringBefore(entiteNomCanoniqueRetourGenerique, "<") : entiteNomCanoniqueRetourGenerique;
//							entiteNomCanoniqueRetourGenerique = entiteNomCanoniqueRetourGenerique.contains(",") ? StringUtils.substringBefore(entiteNomCanoniqueRetourGenerique, ",") : entiteNomCanoniqueRetourGenerique;
//							if(StringUtils.isNotEmpty(entiteNomCanoniqueRetourGenerique)) {
//								indexerStocker(entiteDoc, "entiteNomCanoniqueRetourGenerique", nomLangue, entiteNomCanoniqueRetourGenerique);
//	
//								if(StringUtils.contains(entiteNomCanoniqueRetourGenerique, "."))
//									entiteNomSimpleRetourGenerique = indexerStocker(entiteDoc, "entiteNomSimpleRetourGenerique", nomLangue, StringUtils.substringAfterLast(entiteNomCanoniqueRetourGenerique, "."));
//								else
//									entiteNomSimpleRetourGenerique = indexerStocker(entiteDoc, "entiteNomSimpleRetourGenerique", nomLangue, entiteNomCanoniqueRetourGenerique);
//	
//								if(StringUtils.contains(entiteNomSimpleRetourGenerique, ".")) {
//									entiteNomSimpleRetourComplet = indexerStocker(entiteDoc, "entiteNomSimpleRetourComplet", nomLangue, concat(StringUtils.substringAfterLast(entiteNomSimpleRetour, "."), "<", entiteNomSimpleRetourGenerique, ">"));
//								}
//								else {
//									entiteNomSimpleRetourComplet = indexerStocker(entiteDoc, "entiteNomSimpleRetourComplet", nomLangue, concat(entiteNomSimpleRetour, "<", entiteNomSimpleRetourGenerique, ">"));
//								}
//							}
//							else {
//								entiteNomSimpleRetourComplet = indexerStocker(entiteDoc, "entiteNomCanoniqueRetourComplet", nomLangue, entiteNomSimpleRetour);
//							}
//						}
	
						String entiteCle = classeChemin + "." + entiteVar;
		
						// Entites Solr du entite. 
		
						entiteDoc.addField("cle", entiteCle);
						indexerStocker(entiteDoc, "partEstEntite", true);
						indexerStocker(entiteDoc, "partNumero", partNumero);
	
						String entiteVarLangue = regex("var\\." + nomLangue + ": (.*)", methodeCommentaire);
						entiteVarLangue = indexerStocker(entiteDoc, "entiteVar", nomLangue, entiteVarLangue == null ? entiteVar : entiteVarLangue);
	
						List<String> entiteCommentairesLangue = regexListe("(.*)", methodeCommentaire);
						String entiteCommentaireLangue = indexerStocker(entiteDoc, "entiteCommentaire", nomLangue, StringUtils.join(entiteCommentairesLangue, "\n"));
	
						String entiteBlocCode = methodeQdox.getCodeBlock();
						String entiteBlocCodeLangue = entiteBlocCode;
						ArrayList<String> remplacerClesLangue = regexListe("^r." + nomLangue + "\\s*=\\s*(.*)\\n.*", methodeCommentaire);
						ArrayList<String> remplacerValeursLangue = regexListe("^r." + nomLangue + "\\s*=\\s*.*\\n(.*)", methodeCommentaire);
						for(int i = 0; i < remplacerClesLangue.size(); i++) {
							String cle = remplacerClesLangue.get(i);
							String valeur = remplacerValeursLangue.get(i);
							StringUtils.replace(entiteBlocCodeLangue, cle, valeur);
						}
						stocker(entiteDoc, "entiteBlocCode", nomLangue, entiteBlocCodeLangue); 

						clientSolr.add(entiteDoc); 
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					}
					else {
						// est Méthode. 
						SolrInputDocument methodeDoc = docClasseClone.deepCopy();
						indexerStocker(methodeDoc, "methodeVar", nomLangue, methodeVar);
						for(JavaAnnotation annotation : annotations) {
							String methodeAnnotationLangue = indexerStocker(methodeDoc, "methodeAnnotations", nomLangue, annotation.getType().getCanonicalName());
						}
						Boolean methodeEstVide = false;
						if(classeQdoxRetour != null && !classeQdoxRetour.getCanonicalName().equals("void")) {
							methodeNomCanoniqueRetourComplet = indexerStocker(methodeDoc, "methodeNomCanoniqueRetourComplet", nomLangue, classeQdoxRetour.getGenericCanonicalName());
							methodeNomCanoniqueRetour = indexerStocker(methodeDoc, "methodeNomCanoniqueRetour", nomLangue, classeQdoxRetour.getCanonicalName());
							String methodeNomSimpleRetour = indexerStocker(methodeDoc, "methodeNomSimpleRetour", nomLangue, StringUtils.substringAfterLast(methodeNomCanoniqueRetour, "."));
							String listeNomTypeOrigineRetourGenerique = methodeNomCanoniqueRetourComplet;
							String methodeNomCanoniqueRetourGenerique = StringUtils.substringBeforeLast(StringUtils.substringAfter(listeNomTypeOrigineRetourGenerique, "<"), ">");
							String methodeNomSimpleRetourComplet;
							String methodeNomSimpleRetourGenerique;
							methodeNomCanoniqueRetourGenerique = methodeNomCanoniqueRetourGenerique.contains("<") ? StringUtils.substringBefore(methodeNomCanoniqueRetourGenerique, "<") : methodeNomCanoniqueRetourGenerique;
							methodeNomCanoniqueRetourGenerique = methodeNomCanoniqueRetourGenerique.contains(",") ? StringUtils.substringBefore(methodeNomCanoniqueRetourGenerique, ",") : methodeNomCanoniqueRetourGenerique;
							if(StringUtils.isNotEmpty(methodeNomCanoniqueRetourGenerique)) {
								indexerStocker(methodeDoc, "methodeNomCanoniqueRetourGenerique", nomLangue, methodeNomCanoniqueRetourGenerique);
	
								if(StringUtils.contains(methodeNomCanoniqueRetourGenerique, "."))
									methodeNomSimpleRetourGenerique = indexerStocker(methodeDoc, "methodeNomSimpleRetourGenerique", nomLangue, StringUtils.substringAfterLast(methodeNomCanoniqueRetourGenerique, "."));
								else
									methodeNomSimpleRetourGenerique = indexerStocker(methodeDoc, "methodeNomSimpleRetourGenerique", nomLangue, methodeNomCanoniqueRetourGenerique);
	
								if(StringUtils.contains(methodeNomSimpleRetourGenerique, ".")) {
									methodeNomSimpleRetourComplet = indexerStocker(methodeDoc, "methodeNomSimpleRetourComplet", nomLangue, concat(StringUtils.substringAfterLast(methodeNomSimpleRetour, "."), "<", methodeNomSimpleRetourGenerique, ">"));
								}
								else {
									methodeNomSimpleRetourComplet = indexerStocker(methodeDoc, "methodeNomSimpleRetourComplet", nomLangue, concat(methodeNomSimpleRetour, "<", methodeNomSimpleRetourGenerique, ">"));
								}
							}
							else {
								methodeNomSimpleRetourComplet = indexerStocker(methodeDoc, "methodeNomSimpleRetourComplet", nomLangue, methodeNomSimpleRetour);
							}
						}
						else {
							methodeEstVide = true;
						}
						methodeEstVide = indexerStocker(methodeDoc, "methodeEstVide", methodeEstVide);
	
						String methodeCle = classeChemin + "." + methodeVar;
		
						// Methodes Solr du methode. 
		
						methodeDoc.addField("cle", methodeCle);
						indexerStocker(methodeDoc, "partEstMethode", true);
						indexerStocker(methodeDoc, "partNumero", partNumero);

						indexerStocker(methodeDoc, "methodeEstPublic", methodeQdox.isPublic());
						indexerStocker(methodeDoc, "methodeEstProtege", methodeQdox.isProtected());
						indexerStocker(methodeDoc, "methodeEstPrive", methodeQdox.isPrivate());
						indexerStocker(methodeDoc, "methodeEstStatique", methodeQdox.isStatic());
						indexerStocker(methodeDoc, "methodeEstFinale", methodeQdox.isFinal());
						indexerStocker(methodeDoc, "methodeEstAbstrait", methodeQdox.isAbstract());
						indexerStocker(methodeDoc, "methodeEstNatif", methodeQdox.isNative());
						indexerStocker(methodeDoc, "methodeEstTest", methodeEstTest);
						indexerStocker(methodeDoc, "methodeEstSubstitue", methodeEstSubstitue);
	
						String methodeVarLangue = regex("var\\." + nomLangue + ": (.*)", methodeCommentaire);
						methodeVarLangue =  methodeVarLangue == null ? methodeVar : methodeVarLangue;
	
						List<String> methodeCommentairesLangue = regexListe("^" + nomLangue + ":\\s*([^\n]+)", methodeCommentaire);
						String methodeCommentaireLangue = stocker(methodeDoc, "methodeCommentaire", nomLangue, StringUtils.join(methodeCommentairesLangue, "\n"));

						String methodeCodeSource = methodeQdox.getSourceCode();
						String methodeCodeSourceLangue = methodeCodeSource;
						ArrayList<String> remplacerClesLangue = regexListe("^r." + nomLangue + "\\s*=\\s*(.*)\\n.*", methodeCommentaire);
						ArrayList<String> remplacerValeursLangue = regexListe("^r." + nomLangue + "\\s*=\\s*.*\\n(.*)", methodeCommentaire);
						for(int i = 0; i < remplacerClesLangue.size(); i++) {
							String cle = remplacerClesLangue.get(i);
							String valeur = remplacerValeursLangue.get(i);
							StringUtils.replace(methodeCodeSourceLangue, cle, valeur);
						}
						stocker(methodeDoc, "methodeCodeSource", nomLangue, methodeCodeSourceLangue);
		
						String varEnUS = regex("^var.enUS: (.*)", methodeQdox.getComment());
//						methode.nomMethode.frFR(methodeQdox.getName());
//						methode.nomMethode.enUS(StringUtils.isEmpty(varEnUS) ? methodeQdox.getName() : varEnUS);
//		
//						List<JavaParameter> parametresQdox = methodeQdox.getParameters();
//
//						regexCommentaires(methodeQdox.getComment(), methode.commentaire);
//						regexRemplacerTout(methodeQdox.getComment(), methodeQdox.getSourceCode(), methode.codeSource);
//						methode.classe_(this);
//						methode.initialiserLoinUneMethode(requeteSite);
//						methodes.add(methode);
//						tout.add(methode);

						for(String nomLangue : autresLangues) {  

							methodeVarLangue = regex("methodeVar\\_" + nomLangue + ":\\s*([^\n]+)", methodeCommentaire);
							methodeVarLangue = indexerStocker(methodeDoc, "methodeVar", nomLangue, methodeVarLangue == null ? methodeVar : methodeVarLangue);
		
							methodeCommentairesLangue = regexListe("^" + nomLangue + ":\\s*([^\n]+)", methodeCommentaire);
							methodeCommentaireLangue = stocker(methodeDoc, "methodeCommentaire", nomLangue, StringUtils.join(methodeCommentairesLangue, "\n"));
		
							methodeCodeSourceLangue = regexRemplacerTout(methodeCommentaire, methodeCodeSource, nomLangue);
							stocker(methodeDoc, "methodeCodeSource", nomLangue, methodeCodeSourceLangue);
						}
	
						clientSolr.add(methodeDoc); 
					}
			
						//////////////////
						// Methode Langue //
						//////////////////
		
	//						String methodeVarLangue = regex("var\\." + nomLangue + ": (.*)", methodeCommentaire);
	//						methodeVarLangue = methodeVarLangue == null ? methodeVar : methodeVarLangue;
	//						methodeDoc.addField(concat("methodeVar_", nomLangue, "_indexe_string"), methodeVarLangue);
	//						methodeDoc.addField(concat("methodeVar_", nomLangue, "_stocke_string"), methodeVarLangue);
	//	
	//						List<String> methodeCommentairesLangue = regexListe("(.*)", methodeCommentaire);
	//						String methodeCommentaireLangue = StringUtils.join(methodeCommentairesLangue, "\n");
	//						methodeDoc.addField(concat("methodeCommentaire_", nomLangue, "_indexe_string"), methodeCommentaireLangue);
	//						methodeDoc.addField(concat("methodeCommentaire_", nomLangue, "_stocke_string"), methodeCommentaireLangue);
	//	
	//						String methodeBlocCode = methodeQdox.getCodeBlock();
	//						String methodeBlocCodeLangue = methodeBlocCode;
	//						ArrayList<String> remplacerClesLangue = regexListe("^r." + nomLangue + "\\s*=\\s*(.*)\\n.*", methodeCommentaire);
	//						ArrayList<String> remplacerValeursLangue = regexListe("^r." + nomLangue + "\\s*=\\s*.*\\n(.*)", methodeCommentaire);
	//						for(int i = 0; i < remplacerClesLangue.size(); i++) {
	//							String cle = remplacerClesLangue.get(i);
	//							String valeur = remplacerValeursLangue.get(i);
	//							StringUtils.replace(methodeBlocCodeLangue, cle, valeur);
	//						}
	//						methodeDoc.addField(concat("methodeBlocCode_", nomLangue, "_indexe_string"), methodeBlocCodeLangue);
	//						methodeDoc.addField(concat("methodeBlocCode_", nomLangue, "_stocke_string"), methodeBlocCodeLangue);
	//					
	//						String nomCanoniqueRetourComplet = null;
	//						if(classeQdoxRetour != null && !classeQdoxRetour.getCanonicalName().equals("void"))
	//							nomCanoniqueRetourComplet = classeQdoxRetour.getGenericCanonicalName();
	//		//						methode.nomCanoniqueRetourComplet(classeQdoxRetour.getGenericCanonicalName());
	//		
	//						String nomCanoniqueRetourEnUS = regex("nomCanonique.enUS: (.*)", classeQdoxRetour.getComment());
	//						methode.nomCanoniqueRetour.frFR(StringUtils.substringBefore(nomCanoniqueRetourComplet, "<"));    
	//						methode.nomCanoniqueRetour.enUS(StringUtils.isEmpty(nomCanoniqueRetourEnUS) ? methode.nomCanoniqueRetour.frFR() : nomCanoniqueRetourEnUS);
	//		
	//						if(StringUtils.contains(nomCanoniqueRetourComplet, "<")) {
	//							methode.nomCanoniqueRetourGenerique.frFR(StringUtils.substringAfter(StringUtils.substringBeforeLast(nomCanoniqueRetourComplet, ">"), "<"));  
	//							methode.nomCanoniqueRetourGenerique.enUS(StringUtils.substringAfter(StringUtils.substringBeforeLast(nomCanoniqueRetourComplet, ">"), "<"));  
	//						}
	//						if(StringUtils.contains(methode.nomCanoniqueRetour.toString(), ".")) {
	//							methode.nomSimpleRetour.frFR(StringUtils.substringAfterLast(methode.nomCanoniqueRetour.frFR(), "."));    
	//							methode.nomSimpleRetour.enUS(StringUtils.substringAfterLast(methode.nomCanoniqueRetour.enUS(), "."));    
	//							if(methode.nomCanoniqueRetourGenerique.estVide()) {
	//								methode.nomSimpleRetourComplet.frFR(methode.nomSimpleRetour.frFR());
	//								methode.nomSimpleRetourComplet.enUS(methode.nomSimpleRetour.enUS());
	//							}
	//							else {
	//								if(methode.nomCanoniqueRetourGenerique.contient(".")) {
	//									methode.nomSimpleRetourComplet.frFR(methode.nomSimpleRetour.frFR(), "<", StringUtils.substringAfterLast(methode.nomCanoniqueRetourGenerique.frFR(), "."), ">");    
	//									methode.nomSimpleRetourComplet.enUS(methode.nomSimpleRetour.enUS(), "<", StringUtils.substringAfterLast(methode.nomCanoniqueRetourGenerique.enUS(), "."), ">");    
	//								}
	//								else {
	//									methode.nomSimpleRetourComplet.frFR(methode.nomSimpleRetour.frFR(), "<", methode.nomCanoniqueRetourGenerique.frFR(), ">");    
	//									methode.nomSimpleRetourComplet.enUS(methode.nomSimpleRetour.enUS(), "<", methode.nomCanoniqueRetourGenerique.enUS(), ">");    
	//								}
	//							}
	//						}
	//						else {
	//							methode.nomSimpleRetour.frFR(methode.nomCanoniqueRetour.frFR());
	//							methode.nomSimpleRetour.enUS(methode.nomCanoniqueRetour.enUS());
	//							if(methode.nomCanoniqueRetourGenerique.estVide()) {
	//								methode.nomSimpleRetourComplet.frFR(methode.nomSimpleRetour.frFR());
	//								methode.nomSimpleRetourComplet.enUS(methode.nomSimpleRetour.enUS());
	//							}
	//							else {
	//								methode.nomSimpleRetourComplet.frFR(methode.nomSimpleRetour.frFR(), "<", methode.nomCanoniqueRetourGenerique.frFR(), ">");    
	//								methode.nomSimpleRetourComplet.enUS(methode.nomSimpleRetour.enUS(), "<", methode.nomCanoniqueRetourGenerique.enUS(), ">");    
	//							}
	//						}
	//		
	//						if(methode.nomCanoniqueRetourGenerique.estVide()) {
	//							methode.nomCanoniqueRetourComplet.enUS(methode.nomCanoniqueRetour.enUS());
	//							methode.nomCanoniqueRetourComplet.frFR(methode.nomCanoniqueRetour.frFR());
	//						}
	//						else {
	//							methode.nomCanoniqueRetourComplet.enUS(methode.nomCanoniqueRetour.enUS(), "<", methode.nomCanoniqueRetourGenerique.enUS(), ">");
	//							methode.nomCanoniqueRetourComplet.frFR(methode.nomCanoniqueRetour.frFR(), "<", methode.nomCanoniqueRetourGenerique.frFR(), ">");
	//						}
	//		
	//						String varEnUS = regex("^var.enUS: (.*)", methodeQdox.getComment());
	//						methode.nomMethode.frFR(methodeQdox.getName());
	//						methode.nomMethode.enUS(StringUtils.isEmpty(varEnUS) ? methodeQdox.getName() : varEnUS);
	//		
	//						List<JavaAnnotation> annotations = methodeQdox.getAnnotations();
	//						methode.estSubstitue(false);
	//						for(JavaAnnotation annotation : annotations) {
	//							if("org.junit.Test".equals(annotation.getType().getCanonicalName())) {
	//								methode.estTest(true);
	//							}
	//							if("java.lang.Override".equals(annotation.getType().getCanonicalName())) {
	//								methode.estSubstitue(true);
	//							}
	//						}
	//						List<JavaParameter> parametresQdox = methodeQdox.getParameters();
	//		
	//						if(!methode.estSubstitue && !methode.champEstStatique && !methode.champEstFinale && methodeQdox.getDeclaringClass().equals(classeQdox) 
	//								&& methode.champEstProtege && parametresQdox.size() == 1 && classeQdoxRetour.isVoid()
	//								&& StringUtils.startsWith(methodeQdox.getName(), "_")) {
	//				
	//							String nomEntite = StringUtils.substringAfter(methodeQdox.getName(), "_");
	//							UnEntite entite = new UnEntite();
	//							JavaClass classeEntite = parametresQdox.get(0).getJavaClass();
	//							boolean typeCouverture = false;
	//							String nomTypeOrigine = classeEntite.getGenericCanonicalName();
	//							String nomType = nomTypeOrigine;
	//							String typeNomCanonique = classeEntite.getCanonicalName();
	//		//					JavaClass classeEntite = typeBricoleur.getClassByName(typeNomCanonique);
	//							String listeNomTypeOrigineGenerique = null;
	//							String listeNomTypeGenerique = null;
	//							String listeNomTypeGeneriqueComplet = null;
	//							String varCouverture = nomEntite + varCouvertureCapitalise.toString();
	//		
	//							entite.classe_(this);
	//							entite.requeteSite(requeteSite);
	//		
	//							String varEntiteEnUS = regex("^var.enUS: (.*)", methodeQdox.getComment());
	//							entite.var.frFR(nomEntite);
	//							entite.var.enUS(StringUtils.isEmpty(varEntiteEnUS) ? nomEntite : StringUtils.substringAfter(varEntiteEnUS, "_"));
	//		
	//							regexCommentaires(methodeQdox.getComment(), entite.commentaire);
	//							regexRemplacerTout(methodeQdox.getComment(), methodeQdox.getSourceCode(), entite.codeSource);
	//				
	//							if(classeEntite.getFullyQualifiedName().equals(nomCanoniqueCouvertureActuel)) {
	//								nomType = StringUtils.substringBeforeLast(StringUtils.substringAfter(nomType, "<"), ">");
	//								if(StringUtils.contains(nomType, "<"))
	//									classeEntite = typeBricoleur.getClassByName(StringUtils.substringBefore(nomType, "<"));
	//								else
	//									classeEntite = typeBricoleur.getClassByName(nomType);
	//								typeNomCanonique = classeEntite.getCanonicalName();
	//								typeCouverture = true;
	//								entite.couverture(true);
	//							} 
	//				
	//							entite.classeQdox(classeEntite);
	//							entite.methodeQdox(methodeQdox);
	//							entite.initialiserLoinUnEntite(requeteSite);
	//							entites.add(entite);
	//							if(entite.cleUnique)
	//								varCleUniqueActuel.tout(entite.var);
	//							if(entite.suggere)
	//								varSuggereActuel.tout(entite.var);
	//		
	//							if(!entitesTout.contains(entite))
	//								entitesTout.add(entite);
	//		
	//							tout.add(entite);
	//							importationsAjouter(new Chaine().tout(typeNomCanonique));
	//							importationsGenAjouter(new Chaine().tout(typeNomCanonique));
	//							if(listeNomTypeGenerique != null) {
	//								Chaine importation = new Chaine().tout(listeNomTypeGenerique);
	//								importationsAjouter(importation);
	//								importationsGenAjouter(importation);
	//							}
	//		
	//							boolean etendCluster = entite.etendClasse(nomCanoniqueClusterActuel);
	//							entite.etendCluster(etendCluster);
	//							if(!etendCluster && entite.nomCanoniqueGenerique.pasVide()) {
	//								boolean listeCluster = etendClasse(nomCanoniqueClusterActuel, entite.nomCanoniqueGenerique.toString());
	//								entite.listeCluster(listeCluster);
	//							}
	//		
	//							boolean etendPageXml = entite.etendClasse(nomCanoniquePageXmlActuel);
	//							entite.etendPageXml(etendPageXml);
	//							if(!etendPageXml && entite.nomCanoniqueGenerique.pasVide()) {
	//								boolean listePageXml = etendClasse(nomCanoniquePageXmlActuel, entite.nomCanoniqueGenerique.toString());
	//								entite.listePageXml(listePageXml);
	//							}
	//		
	//							boolean etendPageParti = entite.etendClasse(nomCanoniquePagePartiActuel);
	//							entite.etendPageParti(etendPageParti);
	//							if(!etendPageParti && entite.nomCanoniqueGenerique.pasVide()) {
	//								boolean listePageParti = etendClasse(nomCanoniquePagePartiActuel, entite.nomCanoniqueGenerique.toString());
	//								entite.listePageParti(listePageParti);
	//							}
	//		
	//		
	//							boolean contientRequeteSite = contientChamp(varRequeteSite.toString(), entite.classeQdox);
	//							entite.contientRequeteSite(contientRequeteSite);
	//		
	//							boolean contientSetterString = contientMethode(entite.var.toString(), classeQdoxString);
	//							entite.contientSetterString(contientSetterString);
	//		
	//							entiteEstCmd(entite);
	//						}
	//						else {
	//							regexCommentaires(methodeQdox.getComment(), methode.commentaire);
	//							regexRemplacerTout(methodeQdox.getComment(), methodeQdox.getSourceCode(), methode.codeSource);
	//							methode.classe_(this);
	//							methode.initialiserLoinUneMethode(requeteSite);
	//							methodes.add(methode);
	//							tout.add(methode);
	//						}
				}
			}
		}
		clientSolr.add(classeDoc);
		clientSolr.commit();
		clientSolr.deleteByQuery(concat("classeChemin", "_", nomLangue, "_indexe_string") + ":\"" + classeChemin + "\" AND modifiee_indexe_date:[* TO " + modifiee + "-1MILLI]");
		clientSolr.commit(); 
	}
}
