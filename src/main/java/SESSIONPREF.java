/**
 * @(#)SESSIONPREF.java
 *
 *
 * @author
 * @version 1.00 2009/5/12
 */

public class SESSIONPREF
{
	//Pref for image
	public boolean AutoRotate;
	public boolean AutoFix;
	//Pref for framing
	public boolean TableDetection;
	public boolean bBroken;
	public boolean UnderLine;
	public String DefFrameFile;
	//Recognition
	public boolean bLowQuality;
	public boolean NegCashida;
	public int AvgNoiseSize;
	public int DiaMode;
	public int EngineIndex;
	public byte LTRLang;
	public byte RTLLang;
	public String RecFontName;
	//pref for output
	public boolean NLPOn;
	public short FailChar;
	public String ArabicDisplayFont;
	public String LatinDisplayFont;
	public String XSLPath;

    public SESSIONPREF()
    {
    }


}