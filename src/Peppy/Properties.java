package Peppy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Hashtable;


/**
 * This is were property defaults are defined.
 * Also property values are managed here.
 * If we were to import a property file, this is where the code would be.
 * 
 * Copyright 2013, Brian Risk
 * 
 * 
 * @author Brian Risk
 *
 */
public class Properties {
	
	private static Hashtable<String, Property> allProperties = new Hashtable<String, Property>();
	
	//how many processors does your computer have?  This number should be that number.
	public static int numberOfThreads = Runtime.getRuntime().availableProcessors();
	
	//Define our scoring method
	public static String scoringMethodName = "Peppy.Match_IMP";
	public static MatchConstructor matchConstructor = new MatchConstructor(Properties.scoringMethodName);

	/* properties for spectral cleaning */
	public static int minimumNumberOfPeaksForAValidSpectrum = 2;
	public static double spectrumBucketSize = 100;
	public static int spectrumBucketCount = 10;
	
	//when it comes to calculating theoretical peptide mass, we can use mono or average
	public static boolean useMonoMass = true;
	
	//Sequence digestion
	public static int numberOfMissedCleavages = 1;
	public static double peptideMassMinimum = 400.0;
	public static double peptideMassMaximum = 10000.0;
	public static int minPeptideLength = 5;
	public static int maxPeptideLength = 80;
	public static boolean useSequenceRegion = false;
	public static int sequenceRegionStart = 0;
	public static int sequenceRegionStop = 0;
	
	/*
	 * Cleavage rules
	 */
	public static ArrayList<Character> cleavageAcidList = new ArrayList<Character>();
	public static boolean cleavageAtCarboxylSide = true;
	
	/* mass spectrometer settings */
	public static boolean isITRAQ = false;
	
	
	//Segmenting up job for memory management
	public static int digestionWindowSize = 10000000;
	public static int desiredPeptideDatabaseSize = 10000000;
	public static int maxCombinedProteinLength = 5000000;
	
	//Splicing?
	public static boolean useSpliceVariants = false;
	
	
	//mass error tolerances in PPM
	public static double precursorTolerance = 100;
	public static double fragmentTolerance = 300;
	
	/* ion types */
	public static double rightIonDifference = 1.0072764668; //x, y, z ion
	public static double leftIonDifference = 1.0072764668;  //a, b, c ion
//	public static double rightIonDifference = 1.0; //x, y, z ion
//	public static double leftIonDifference = 1.0;  //a, b, c ion
	
	public static double minimumScore = 12;
	
	//This could be a directory or a file
	public static File sequenceDirectoryOrFile = new File("sequences");
	
	/* a list of peptide databases that will be iterated through in our search */
	public static ArrayList<File> sequenceDirectoryOrFileList = new ArrayList<File>();
	/* an ordered list of the database type (DNA, protein etc) for our peptide sources */
	public static ArrayList<Boolean> isSequenceFileDNAList = new ArrayList<Boolean>();
	/* a list of spectra sources that will be iterated through in our search */
	public static ArrayList<File> spectraDirectoryOrFileList = new ArrayList<File>();
	
	//This could be a directory or a file
	public static File spectraDirectoryOrFile = new File("spectra");
	
	//FASTA files can be either DNA or amino acid sequences
	public static boolean isSequenceFileDNA = true;
	
	//Is the sequence file supposed to be read only in the first frame?
	public static boolean useOnlyForwardsFrames = false;
	
	//where we store our reports
	public static File reportDirectory = new File("reports");
	
	//where we put our validation report
	public static File validationDirectory = new File("validation");
	
	//Report related
	public static boolean createHTMLReport = true;
	
	public static String reportWebSuffix = ".html";
	public static File reportWebHeaderFile = new File("resources/reports/header.txt");
	public static File reportWebHeaderSubFile = new File("resources/reports/header-sub.txt");
	public static File reportWebFooterFile = new File("resources/reports/footer.txt");
	public static File reportWebTableHeader = new File("resources/reports/index-table-header.txt");
	
	public static String UCSCdatabase = "clade=mammal&org=Human&db=hg19";
	

	/* for testing purposes */
	public static boolean thisIsATest = false;
	public static File testSequence;
	public static boolean testSequenceIsProtein = true;
	public static File testDirectory; 
	
	/* for custom jobs... */
	public static boolean isYale = false;
	
	/* for VCF Files*/
	public static String VCFFileString;
	
	/* FDR false discovery rate */
	public static int numberOfSpectraToUseForFDR = 10000;
	public static double maximumFDR = 0.01;
	
	/* PTMs */
	public static boolean multipass = false;
	public static int numberOfRegionsToKeep = 1000;
	public static boolean searchModifications = false;
	public static double modificationLowerBound = -0.3;
	public static double modificationUpperBound = 100;
	
	/* when precursors are off by whole daltons */
	public static boolean useHydrogenOffset = false;
	
	/* fixed modifications */
	public static double modA = 0;
	public static double modR = 0;
	public static double modN = 0;
	public static double modD = 0;
	public static double modC = 0;
	public static double modE = 0;
	public static double modQ = 0;
	public static double modG = 0;
	public static double modH = 0;
	public static double modI = 0;
	public static double modL = 0;
	public static double modK = 0;
	public static double modM = 0;
	public static double modF = 0;
	public static double modP = 0;
	public static double modS = 0;
	public static double modT = 0;
	public static double modW = 0;
	public static double modY = 0;
	public static double modV = 0;
	public static double modU = 0;
	public static double modNTerminal = 0;
	public static double modCTerminal = 0;
	
	public static boolean smartTolerances = true;
	
	/* how we format our percents */
	public static NumberFormat percentFormat = NumberFormat.getPercentInstance();
	
	/* Tailoring operation */
	public static boolean simpleSearch = false;
	public static boolean expires = true;
	
	/* Selenocysteine */
	public static boolean useSelenocysteine = false;
	
	public static void init() {
		allProperties = new Hashtable<String, Property>();
		
		//how many processors does your computer have?  This number should be that number.
		numberOfThreads = Runtime.getRuntime().availableProcessors();
		
		//Define our scoring method
		scoringMethodName = "Peppy.Match_IMP";
		matchConstructor = new MatchConstructor(Properties.scoringMethodName);

		/* properties for spectral cleaning */
		minimumNumberOfPeaksForAValidSpectrum = 2;
		spectrumBucketSize = 100;
		spectrumBucketCount = 10;
		
		//when it comes to calculating theoretical peptide mass, we can use mono or average
		useMonoMass = true;
		
		//Sequence digestion
		numberOfMissedCleavages = 1;
		peptideMassMinimum = 400.0;
		peptideMassMaximum = 10000.0;
		minPeptideLength = 5;
		maxPeptideLength = 80;
		useSequenceRegion = false;
		sequenceRegionStart = 0;
		sequenceRegionStop = 0;
		
		/*
		 * Cleavage rules
		 */
		cleavageAcidList = new ArrayList<Character>();
		cleavageAtCarboxylSide = true;
		
		/* mass spectrometer settings */
		isITRAQ = false;
		
		
		//Segmenting up job for memory management
		digestionWindowSize = 10000000;
		desiredPeptideDatabaseSize = 10000000;
		maxCombinedProteinLength = 5000000;
		
		//Splicing?
		useSpliceVariants = false;
		
		
		//mass error tolerances in PPM
		precursorTolerance = 100;
		fragmentTolerance = 300;
		
		/* ion types */
		rightIonDifference = 1.0072764668; //x, y, z ion
		leftIonDifference = 1.0072764668;  //a, b, c ion
//		rightIonDifference = 1.0; //x, y, z ion
//		leftIonDifference = 1.0;  //a, b, c ion
		
		minimumScore = 12;
		
		//This could be a directory or a file
		sequenceDirectoryOrFile = new File("sequences");
		
		/* a list of peptide databases that will be iterated through in our search */
		sequenceDirectoryOrFileList = new ArrayList<File>();
		/* an ordered list of the database type (DNA, protein etc) for our peptide sources */
		isSequenceFileDNAList = new ArrayList<Boolean>();
		/* a list of spectra sources that will be iterated through in our search */
		spectraDirectoryOrFileList = new ArrayList<File>();
		
		//This could be a directory or a file
		spectraDirectoryOrFile = new File("spectra");
		
		//FASTA files can be either DNA or amino acid sequences
		isSequenceFileDNA = true;
		
		//Is the sequence file supposed to be read only in the first frame?
		useOnlyForwardsFrames = false;
		
		//where we store our reports
		reportDirectory = new File("reports");
		
		//where we put our validation report
		validationDirectory = new File("validation");
		
		//Report related
		createHTMLReport = true;
		
		reportWebSuffix = ".html";
		reportWebHeaderFile = new File("resources/reports/header.txt");
		reportWebHeaderSubFile = new File("resources/reports/header-sub.txt");
		reportWebFooterFile = new File("resources/reports/footer.txt");
		reportWebTableHeader = new File("resources/reports/index-table-header.txt");
		
		UCSCdatabase = "clade=mammal&org=Human&db=hg19";
		

		
		/* for custom jobs... */
		isYale = false;
		
		
		/* FDR false discovery rate */
		numberOfSpectraToUseForFDR = -1;
		maximumFDR = 0.01;
		
		/* when off by whole dalton*/
		useHydrogenOffset = false;
		
		/* fixed modifications */
		 modA = 0;
		 modR = 0;
		 modN = 0;
		 modD = 0;
		 modC = 0;
		 modE = 0;
		 modQ = 0;
		 modG = 0;
		 modH = 0;
		 modI = 0;
		 modL = 0;
		 modK = 0;
		 modM = 0;
		 modF = 0;
		 modP = 0;
		 modU = 0;
		 modS = 0;
		 modT = 0;
		 modW = 0;
		 modY = 0;
		 modV = 0;
		 modNTerminal = 0;
		 modCTerminal = 0;
		
		/* PTMs */
		multipass = false;
		numberOfRegionsToKeep = 1000;
		searchModifications = false;
		modificationLowerBound = -0.3;
		modificationUpperBound = 100;
		
		
		
		smartTolerances = true;
		
		/* how we format our percents */
		percentFormat = NumberFormat.getPercentInstance();
		
		useSelenocysteine = false;
	}
	
	
	public static void loadProperties(String fileName) {
		File propertiesFile = new File(fileName);
		loadProperties(propertiesFile);
	}
	
	
	/**
	 * 
	 * @param fileName the name of our properties file
	 */
	public static void loadProperties(File propertiesFile) {
		
		/* All arrays must be cleared for multiple jobs to work!  clearing out our arrays */
		/* this means that spectra and sequences must be set in each job file; they cannot be blank */
		sequenceDirectoryOrFileList = new ArrayList<File>();
		isSequenceFileDNAList = new ArrayList<Boolean>();
		spectraDirectoryOrFileList = new ArrayList<File>();
		cleavageAcidList = new ArrayList<Character>();
		
		/* loading in the values from the properties file */
		try {
			BufferedReader br = new BufferedReader(new FileReader(propertiesFile));
			String line = br.readLine();
			while (line != null) {
				setPropertyFromString(line);
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			U.p("Could not find the properties file: " + propertiesFile.getName());
			U.p("Using default properties...");
		} catch (IOException e) {
			U.p("Could not read the properties file: " + propertiesFile.getName());
			e.printStackTrace();
		}
		
		/* for our formatting */
		percentFormat.setMaximumFractionDigits(2);
		
		/* set default digestion */
		if (cleavageAcidList.size() == 0) {
			cleavageAcidList.add('R');
			cleavageAcidList.add('K');
		}
		
		
		
	}
	
	public static void setAllProperties() {
		numberOfThreads = allProperties.get("numberOfThreads").getInt();
	}
	
	private static void setPropertyFromString(String line) {
		line = line.trim();
		
		/* ignore blank lines */
		if (line.equals("")) return;
		
		/* ignore comments */
		if (line.startsWith("//")) return;
		if (line.startsWith("#")) return;
		
		/* ignore lines that do not have a space in them */
		if (line.indexOf(" ") == -1) return;
		
		/* getting the property name and the property value */
		String propertyName = line.substring(0, line.indexOf(" "));
		String propertyValue = line.substring(line.indexOf(" ") + 1, line.length());
		
		/* threads */
		if (propertyName.equals("numberOfThreads")) 
			numberOfThreads = Integer.valueOf(propertyValue);
		
		/* for straight-forward searches (no FDR, no auto parameters, no mod search, etc.) */
		if (propertyName.equals("simpleSearch"))
			simpleSearch = Boolean.valueOf(propertyValue);
		
		
		
		//sequence digestion
		if (propertyName.equals("numberOfMissedCleavages")) 
			numberOfMissedCleavages =Integer.valueOf(propertyValue);
		if (propertyName.equals("peptideMassThreshold")) 
			peptideMassMinimum = Double.valueOf(propertyValue);
		if (propertyName.equals("peptideMassMinimum")) 
			peptideMassMinimum = Double.valueOf(propertyValue);
		if (propertyName.equals("peptideMassMaximum")) 
			peptideMassMaximum = Double.valueOf(propertyValue);
		if (propertyName.equals("useSequenceRegion"))
			useSequenceRegion = Boolean.valueOf(propertyValue);
		if (propertyName.equals("sequenceRegionStart")) 
			sequenceRegionStart =Integer.valueOf(propertyValue);
		if (propertyName.equals("sequenceRegionStop")) 
			sequenceRegionStop =Integer.valueOf(propertyValue);
		if (propertyName.equals("minPeptideLength")) 
			minPeptideLength =Integer.valueOf(propertyValue);
		if (propertyName.equals("maxPeptideLength")) 
			maxPeptideLength =Integer.valueOf(propertyValue);
		if (propertyName.equals("cleavageAcid"))  {
			cleavageAcidList.add(propertyValue.toUpperCase().charAt(0));
		}
		if (propertyName.equals("cleavageAtCarboxylSide"))
			cleavageAtCarboxylSide = Boolean.valueOf(propertyValue);
		
		
		/* mass spectrometer parameters */
		if (propertyName.equals("isITRAQ"))
			isITRAQ = Boolean.valueOf(propertyValue);
		
		
		//job parsing for memory management
		if (propertyName.equals("digestionWindowSize")) 
			digestionWindowSize =Integer.valueOf(propertyValue);
		if (propertyName.equals("desiredPeptideDatabaseSize")) 
			desiredPeptideDatabaseSize =Integer.valueOf(propertyValue);
		if (propertyName.equals("maxCombinedProteinLength")) 
			maxCombinedProteinLength =Integer.valueOf(propertyValue);
		
		
		if (propertyName.equals("minimumScore")) 
			minimumScore = Double.valueOf(propertyValue);
			
		
		//splicing
		if (propertyName.equals("useSpliceVariants"))
			useSpliceVariants = Boolean.valueOf(propertyValue);
		
		
		
		//spectrum cleaning		
		if (propertyName.equals("minimumNumberOfPeaksForAValidSpectrum")) 
			minimumNumberOfPeaksForAValidSpectrum =Integer.valueOf(propertyValue);
		
	
		if (propertyName.equals("sequenceDirectoryOrFile")) {
			sequenceDirectoryOrFile = new File(propertyValue);
			sequenceDirectoryOrFileList.add(sequenceDirectoryOrFile);
		}
		if (propertyName.equals("spectraDirectoryOrFile")) { 
			spectraDirectoryOrFile = new File(propertyValue);
			spectraDirectoryOrFileList.add(spectraDirectoryOrFile);
		}
		if (propertyName.equals("isSequenceFileDNA")) {
			isSequenceFileDNA = Boolean.valueOf(propertyValue);
			isSequenceFileDNAList.add(isSequenceFileDNA);
		}
		if (propertyName.equals("useOnlyForwardsFrames")) {
			useOnlyForwardsFrames = Boolean.valueOf(propertyValue);
		}
		
		
		
		
		//Scoring method
		if (propertyName.equals("scoringMethodName")) {
			scoringMethodName = propertyValue;
			matchConstructor = new MatchConstructor(scoringMethodName);
		}
		
		if (propertyName.equals("leftIonDifference"))
			leftIonDifference = Double.valueOf(propertyValue);
		if (propertyName.equals("rightIonDifference")) 
			rightIonDifference = Double.valueOf(propertyValue);

		//Ion and precursor threshold values
		if (propertyName.equals("precursorTolerance")) 
			precursorTolerance = Double.valueOf(propertyValue);
		if (propertyName.equals("fragmentTolerance")) 
			fragmentTolerance = Double.valueOf(propertyValue);
		
		//Old ion/precursor value names
		if (propertyName.equals("spectrumToPeptideMassError")) 
			precursorTolerance = Double.valueOf(propertyValue);
		if (propertyName.equals("peakDifferenceThreshold")) 
			fragmentTolerance = Double.valueOf(propertyValue);
		
		
		//reports
		if (propertyName.equals("reportDirectory")) 
			reportDirectory = new File(propertyValue);
		if (propertyName.equals("createHTMLReport")) 
			createHTMLReport = Boolean.valueOf(propertyValue);
		
		/* for testing purposes */
		if (propertyName.equals("thisIsATest")) 
			thisIsATest = Boolean.valueOf(propertyValue);
		if (propertyName.equals("testSequence")) 
			testSequence = new File(propertyValue);
		if (propertyName.equals("testSequenceIsProtein")) 
			testSequenceIsProtein = Boolean.valueOf(propertyValue);
		if (propertyName.equals("testDirectory")) 
			testDirectory = new File(propertyValue);
		if (propertyName.equals("VCFFileString")) 
			VCFFileString = propertyValue;
		
		
		if (propertyName.equals("UCSCdatabase")) 
			UCSCdatabase = propertyValue;
		
		
		/* custom jobs */
		if (propertyName.equals("isYale")) 
			isYale = Boolean.valueOf(propertyValue);
		
		/* FDR */
		if (propertyName.equals("numberOfSpectraToUseForFDR"))
			numberOfSpectraToUseForFDR = Integer.valueOf(propertyValue);	
		if (propertyName.equals("maximumFDR"))
			maximumFDR = Double.valueOf(propertyValue);	
		
		
		
		/* multipass */
		if (propertyName.equals("multipass")) 
			multipass = Boolean.valueOf(propertyValue);
		if (propertyName.equals("numberOfRegionsToKeep"))
			numberOfRegionsToKeep = Integer.valueOf(propertyValue);	
		if (propertyName.equals("searchModifications")) 
			searchModifications = Boolean.valueOf(propertyValue);
		if (propertyName.equals("modificationLowerBound")) 
			modificationLowerBound = Double.valueOf(propertyValue);
		if (propertyName.equals("modificationUpperBound")) 
			modificationUpperBound = Double.valueOf(propertyValue);
		
		/* hydrogen offset */
		if (propertyName.equals("useHydrogenOffset")) 
			useHydrogenOffset = Boolean.valueOf(propertyValue);
		
		
		/* fixed modifications */
		if (propertyName.equals("modA")) modA = Double.valueOf(propertyValue);
		if (propertyName.equals("modR")) modR = Double.valueOf(propertyValue);
		if (propertyName.equals("modN")) modN = Double.valueOf(propertyValue);
		if (propertyName.equals("modD")) modD = Double.valueOf(propertyValue);
		if (propertyName.equals("modC")) modC = Double.valueOf(propertyValue);
		if (propertyName.equals("modE")) modE = Double.valueOf(propertyValue);
		if (propertyName.equals("modQ")) modQ = Double.valueOf(propertyValue);
		if (propertyName.equals("modG")) modG = Double.valueOf(propertyValue);
		if (propertyName.equals("modH")) modH = Double.valueOf(propertyValue);
		if (propertyName.equals("modI")) modI = Double.valueOf(propertyValue);
		if (propertyName.equals("modL")) modL = Double.valueOf(propertyValue);
		if (propertyName.equals("modK")) modK = Double.valueOf(propertyValue);
		if (propertyName.equals("modM")) modM = Double.valueOf(propertyValue);
		if (propertyName.equals("modF")) modF = Double.valueOf(propertyValue);
		if (propertyName.equals("modP")) modP = Double.valueOf(propertyValue);
		if (propertyName.equals("modS")) modS = Double.valueOf(propertyValue);
		if (propertyName.equals("modT")) modT = Double.valueOf(propertyValue);
		if (propertyName.equals("modW")) modW = Double.valueOf(propertyValue);
		if (propertyName.equals("modY")) modY = Double.valueOf(propertyValue);
		if (propertyName.equals("modV")) modV = Double.valueOf(propertyValue);
		if (propertyName.equals("modU")) modU = Double.valueOf(propertyValue);
		if (propertyName.equals("modNTerminal")) modNTerminal = Double.valueOf(propertyValue);
		if (propertyName.equals("modCTerminal")) modCTerminal = Double.valueOf(propertyValue);

		
		/* legacy modification -- might be used if old properties file is employed */
		if (propertyName.equals("iodoacetamideDerivative"))
			Properties.modC = 57.021464;


		/* smart tolerances */
		if (propertyName.equals("smartTolerances")) 
			smartTolerances = Boolean.valueOf(propertyValue);
		
		if (propertyName.equals("useSelenocysteine")) 
			useSelenocysteine = Boolean.valueOf(propertyValue);
	}


	public static void generatePropertiesFile(File reportDir) {	
		reportDir.mkdirs();
		//set up our main index file
		File ppropertiesFile = new File(reportDir, "properties.txt");
		PrintWriter pw;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(ppropertiesFile)));
			
			pw.println("##This could be a directory or a file ");
			for (File file: sequenceDirectoryOrFileList) {
				pw.println("sequenceDirectoryOrFile " + file.getAbsolutePath());
			}
			for (Boolean bool: isSequenceFileDNAList) {
				pw.println("isSequenceFileDNA " + bool);
			}
			pw.println("useOnlyForwardsFrames " + Properties.useOnlyForwardsFrames);
			pw.println();
			pw.println("##This could be a directory or a file ");
			for (File file: spectraDirectoryOrFileList) {
				pw.println("spectraDirectoryOrFile " + file.getAbsolutePath());
			}
			pw.println();
			pw.println("##Digestion rules");
			for (Character acid: cleavageAcidList) {
				pw.println("cleavageAcid " + acid);
			}	
			pw.println("cleavageAtCarboxylSide " + Properties.cleavageAtCarboxylSide);
			pw.println();
			pw.println("isITRAQ " + Properties.isITRAQ);
			pw.println();
			pw.println("##Spectrum cleaning");
			pw.println("minimumNumberOfPeaksForAValidSpectrum " + Properties.minimumNumberOfPeaksForAValidSpectrum);
			pw.println();
			pw.println("##Scoring Method ");
			pw.println("scoringMethodName " + Properties.scoringMethodName);
			pw.println();
			pw.println("##digest only part of a sequence ");
			pw.println("useSequenceRegion " + Properties.useSequenceRegion);
			pw.println("sequenceRegionStart " + Properties.sequenceRegionStart);
			pw.println("sequenceRegionStop " + Properties.sequenceRegionStop);
			pw.println();
			pw.println("##Memory contols ");
			pw.println("digestionWindowSize " + Properties.digestionWindowSize);
			pw.println("desiredPeptideDatabaseSize " + Properties.desiredPeptideDatabaseSize);
			pw.println("minimumScore " + Properties.minimumScore);
			pw.println();
			pw.println("##error thresholds in PPM");
			pw.println("precursorTolerance " + Properties.precursorTolerance);
			pw.println("fragmentTolerance " + Properties.fragmentTolerance);
			pw.println();
			pw.println("##Report variables ");
			pw.println("createHTMLReport " + Properties.createHTMLReport);
			pw.println("UCSCdatabase " + Properties.UCSCdatabase);
			pw.println();
			pw.println("##no fragments that weigh less than this will be admitted into the fragment list ");
			pw.println("##units are daltons. ");
			pw.println("peptideMassMinimum " + Properties.peptideMassMinimum);
			pw.println("peptideMassMaximum " + Properties.peptideMassMaximum);
			pw.println();
			pw.println("numberOfMissedCleavages " + Properties.numberOfMissedCleavages);
			pw.println();
			pw.println("##splicing ");
			pw.println("useSpliceVariants " + Properties.useSpliceVariants);
			pw.println();
			pw.println("##where we store our reports ");
			pw.println("reportDirectory " + Properties.reportDirectory);
			pw.println();
			pw.println("##VCF");
			pw.println("VCFFileString " + VCFFileString);
			pw.println();
			pw.println("##False Discovery Rates");
			pw.println("numberOfSpectraToUseForFDR " + numberOfSpectraToUseForFDR);
			pw.println("maximumFDR " + maximumFDR);
			pw.println();
			pw.println("##multipass");
			pw.println("multipass " + multipass);
			pw.println("searchModifications " + searchModifications);
			pw.println("modificationLowerBound " + modificationLowerBound);
			pw.println("modificationUpperBound " + modificationUpperBound);
			pw.println("numberOfRegionsToKeep " + numberOfRegionsToKeep);
			
			pw.println();
			pw.println("useHydrogenOffset " + useHydrogenOffset);
			pw.println();
			pw.println("## static mods");
			pw.println("modA " + modA);
			pw.println("modR " + modR);
			pw.println("modN " + modN);
			pw.println("modD " + modD);
			pw.println("modC " + modC);
			pw.println("modE " + modE);
			pw.println("modQ " + modQ);
			pw.println("modG " + modG);
			pw.println("modH " + modH);
			pw.println("modI " + modI);
			pw.println("modL " + modL);
			pw.println("modK " + modK);
			pw.println("modM " + modM);
			pw.println("modF " + modF);
			pw.println("modP " + modP);
			pw.println("modS " + modS);
			pw.println("modT " + modT);
			pw.println("modW " + modW);
			pw.println("modY " + modY);
			pw.println("modV " + modV);
			pw.println("modU " + modU);
			pw.println("modNTerminal " + modNTerminal);
			pw.println("modCTerminal " + modCTerminal);

			
			pw.println();
			pw.println("smartTolerances " + smartTolerances);
			
			pw.println();
			pw.println("useSelenocysteine " + useSelenocysteine);
			
			
			
			
	
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	

}