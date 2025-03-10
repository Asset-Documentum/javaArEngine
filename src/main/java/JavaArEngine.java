/**

 * @version 1.00 2009/5/7
 */

public class JavaArEngine {


	//Load the OCR engine DLL
	static {
		try {
			// Load DLL from resources using fully qualified class names
			java.io.InputStream input = JavaArEngine.class.getClassLoader().getResourceAsStream("libs/ArOCREngineDLL.dll");
			if (input == null) {
				throw new RuntimeException("DLL not found in resources!");
			}

			// Create a temporary file
			java.io.File tempFile = java.io.File.createTempFile("ArOCREngineDLL", ".dll");
			tempFile.deleteOnExit(); // Clean up on exit

			// Copy DLL from resources to the temp file
			try (java.io.FileOutputStream out = new java.io.FileOutputStream(tempFile)) {
				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = input.read(buffer)) != -1) {
					out.write(buffer, 0, bytesRead);
				}
			}

			// Load the DLL from the temp file
			System.load(tempFile.getAbsolutePath());
		} catch (java.io.IOException e) {
			throw new RuntimeException("Failed to load DLL: " + e.getMessage());
		}
	}

	//=====================================================================================
	//Exported Functions List
	public static native int ARInitOCREngine();
	public static native int ARFreeOCREngine();
	//GLobal initialization
	// int ARInitOCREngine ();
	// int ARFreeOCREngine();
	//====================
	//Session Manipulation
	public static native int ARInitSession(long [] SessionID);
	public static native int ARFreeSession(long [] SessionID);
	//====================
	// Image Loading and navigation
	public static native int AROpenImage (long [] SessionID, String szImageFileName,short ImagePageIndex);
	public static native int ARGetNumImagePages (long [] SessionID,short [] NumPage);
	public static native int ARSetImageIndex(long [] SessionID, int PageIndex);

	public static native int ARCloseImage(long [] SessionID);
	public static native int ARGetCurImage(long [] SessionID,long [] ImgData);
	public static native int ARSetCurImage(long [] SessionID,long [] ImgData);
	public static native int ARFreeImage(long [] ImgData);
	//====================
	//Image Processing
	public static native int ARInvertImageRect (long [] SessionID,short left, short top, short right, short bottom);
	public static native int ARInvertImage (long [] SessionID);
	public static native int ARRotateImage (long [] SessionID, short Rotation);
	public static native int ARFixImage (long [] SessionID);
	public static native int ARSmoothImage (long [] SessionID);
	public static native int ARSetMargin(long [] SessionID, short sLeftMar, short sTopMar, short sRightMar, short sButtMar);
	public static native int ARSaveImage (long [] SessionID, String szImageFileName, short ImgFormat);
	//====================
	//Preferences Functions
	public static native int ARSetDefaultRecOptions(long [] SessionID); //put default settings
	public static native int ARSetAutoRotate(long [] SessionID, boolean On);
	public static native int ARSetAutoFix(long [] SessionID, boolean On);
	public static native int ARSetTableDetection(long [] SessionID, boolean On);
	public static native int ARSetBroken(long [] SessionID, boolean On);
	public static native int ARSetUnderLine(long [] SessionID, boolean On);
	public static native int ARSetDefFrameFile(long [] SessionID, String FrameFile);
	public static native int ARSetLowQuality(long [] SessionID, int Low);
	public static native int ARSetNegCashida(long [] SessionID, int Cashida);
	public static native int ARSetNoiseSize(long [] SessionID, int noiseSize);
	public static native int ARSetDiaMode(long [] SessionID, int DiaMode);
	public static native int ARSetEngineIndex(long [] SessionID, int Index);

	public static native int ARSetLang(long [] SessionID, byte RTL, byte LTR);
	public static native int ARSetRecFontName(long [] SessionID, String RecFontName);
	public static native int ARSetNLPOn(long [] SessionID, boolean On);
	public static native int ARSetFailChar(long [] SessionID, short Character);
	public static native int ARSetArabicDisplayFont(long [] SessionID, String ArFont);
	public static native int ARSetLatinDisplayFont(long [] SessionID, String LtnFont);
	public static native int ARSetXSLPath(long [] SessionID, String Path);
	//int ARSetImageSave(long* SessionID,BOOL saveImage);

	public static native int ARGetAutoRotate(long [] SessionID, boolean [] On);
	public static native int ARGetAutoFix(long [] SessionID, boolean [] On);
	public static native int ARGetTableDetection(long [] SessionID, boolean [] On);
	public static native int ARGetBroken(long [] SessionID, boolean [] On);
	public static native int ARGetUnderLine(long [] SessionID, boolean [] On);
	public static native int ARGetDefFrameFile(long [] SessionID, String [] FrameFile);
	public static native int ARGetbLowQuality(long [] SessionID, int [] Low);
	public static native int ARGetNegCashida(long [] SessionID, int [] Cashida);
	public static native int ARGetNoiseSize(long [] SessionID,int [] noiseSize);
	public static native int ARGetDiaMode(long [] SessionID, int [] DiaMode);
	public static native int ARGetEngineIndex(long [] SessionID,int [] Index);
	public static native int ARGetLang(long [] SessionID, byte [] RTL, byte [] LTR);
	public static native int ARGetRecFontName(long [] SessionID, String [] RecFontName);
	public static native int ARGetNLPOn(long [] SessionID, boolean [] On);
	public static native int ARGetFailChar(long [] SessionID, short []  Character);
	public static native int ARGetArabicDisplayFont(long [] SessionID, String [] ArFont);
	public static native int ARGetLatinDisplayFont(long [] SessionID, String [] LtnFont);
	public static native int ARGetXSLPath(long [] SessionID, String [] Path);
	//int ARGetImageSave(long* SessionID,BOOL* saveImage);


	//====================
	public static native int ARSetSessionPref(long [] SessionID, SESSIONPREF SessionPref);
	public static native int ARGetSessionPref(long [] SessionID, SESSIONPREF SessionPref);
	public static native int ARSaveSessionPref(long [] SessionID, String lpFileName);
	public static native int ARLoadSessionPref(long [] SessionID,  String lpFileName);

	public static native int ARSetImageSave(long [] SessionID, boolean saveImage);
	public static native int ARGetImageSave(long [] SessionID, boolean [] saveImage);
	public static native int ARSaveARTAs(String ArtName, String outFileName, int Format);

	//====================
	//Framing Functions
	public static native int ARAutomaticFrame (long [] SessionID);
	public static native int ARApplyFrameFile (long [] SessionID, String szFrmFileName);
	public static native int ARAddIncFrame(long [] SessionID, short left, short top, short right, short bottom);
	public static native int ARAddImageFrame (long [] SessionID,short left, short top, short right, short bottom);
	public static native int ARAddExcFrame(long [] SessionID, short left, short top, short right, short bottom);
	public static native int ARClearFrame (long [] SessionID, short FrameIndex, short FrameType);
	public static native int ARClearAllFrames (long [] SessionID);
	public static native int AROptimizeFrame(long [] SessionID, short FrameIndex);
	public static native int ARSaveFrames(long [] SessionID, String szFrmFileName);
	public static native int ARGetFrameCount(long [] SessionID, short FrameType , short [] pCount);
	public static native int ARGetFrameRect(long [] SessionID,short FrameIndex, short FrameType,short [] left, short [] top, short [] right, short [] bottom);
	public static native int ARIsImageFrame(long [] SessionID,short FrameIndex, boolean [] YESNO);
	//====================
	//Recognition functions
	public static native int ARRecognizeImage (long [] SessionID, boolean bAppend);
	public static native int ARGetRecognitionStatistics(long [] SessionID,long [] nLineCount, long [] nCharCount, long [] nFailureCount);
	public static native int ARSaveSession(long [] SessionID, String FileName, short FileType, boolean Append);
	//====================
	//Data Manipulation
	public static native int ARGetNumOfPages(long [] SessionID, short [] nCount);
	public static native int  ARGetNumOfTextFrames(long [] SessionID, short nPageIndex, short [] nCount);
	public static native int ARGetNumOfTableFrames(long [] SessionID, short nPageIndex, short [] nCount);
	public static native int ARGetNumOfTableCells(long [] SessionID, short nPageIndex, short TableIndex, short [] nCount);
	public static native int ARGetImageFileName(long [] SessionID, short nPageIndex, String [] szImageFileName);
	public static native int ARGetPageIndexInImage(long [] SessionID ,short nPageIndex, short [] nImgPageIndex);
	public static native int ARGetFrameLang(long [] SessionID, short nPageIndex, short nFrameIndex, byte [] nRTLlang, byte [] nLTRlang);
	public static native int ARGetFontFileName(long [] SessionID, short nPageIndex, short nFrameIndex, String [] szFontFileName);
	public static native int ARGetCharCountInTextFrame(long [] SessionID, short nPageIndex, short nFrameIndex, short [] nCharCount);
	public static native int ARGetChar(long [] SessionID, short PageIndex, short FrameIndex, short CharIndex, CHARINFO Character);
	/*new*/	public static native int ARReadCharInfo(long [] SessionID, short PageIndex, short FrameIndex, short CharIndex, short [] ChCode, short [] ChQuality, int [] Left, int [] Top, int [] Right, int [] Bottom);

	//++MIAA 25-6-2008
	public static native int ARSetFrameAttribute(long [] SessionID, int nFrameIndex, FRAMESETTING frameSet);
	public static native int ARGetFrameAttribute(long [] SessionID, int nFrameIndex, FRAMESETTING frameSet);

	//====================
	//Scan Functions:
	public static native int ARSelectScanScanner();	//launch the wizard
	/**/	public static native int ARSetScanOptions(int Resolution, int ColorMode, int Duplex, int LeftMargin, int TopMargin, int ScanWidth, int ScanHeight);
	/**/ 	public static native int ARSetDefScanOptions();
	public static native int ARScanOneImage(String SaveFile, short FileType);
	public static native int ARScanMultiple(String ImgDir, String szImgName, short wSeqConv, short FileType);
	//====================

	public JavaArEngine() {
	}


}
