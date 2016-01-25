import java.applet.*;
import java.awt.*;

//Run at 700px by 650px
public class SinusoidalGrapher extends Applet
{
    int x1, y1, x2, y2, x1p, y1p, x2p, y2p;
    //Labels
    Label SIN = new Label ("SIN  CURVE (R)");
    Label sinamplabel = new Label ("Amplitude:");
    Label sinperlabel = new Label ("Period:");
    Label sinhorlabel = new Label ("Horizontal Shift:");
    Label sinverlabel = new Label ("Vertical Shift:");
    Label COS = new Label ("COS CURVE (B)");
    Label cosamplabel = new Label ("Amplitude:");
    Label cosperlabel = new Label ("Period:");
    Label coshorlabel = new Label ("Horizontal Shift:");
    Label cosverlabel = new Label ("Vertical Shift:");
    Label slopexlabel = new Label ("Find m at xvalue:");
    Label areaxleftlabel = new Label ("\t\tArea Left");
    Label areaxrightlabel = new Label ("\t  Right");
    Button submit;
    //TextFields
    TextField sinampt, sinpert, sinhort, sinvert, cosampt, cospert, coshort, cosvert, slopext, areaxleftt, areaxrightt;
    //Variables
    boolean inputed;
    double sinamp = 1.0, sinper = 360.0, sinhor = 0.0, sinver = 0.0, cosamp = 1.0, cosper = 360.0, coshor = 0.0, cosver = 0.0, slopex = 90, sinslope = 0, cosslope = 0, areaxleft = 0, areaxright = 90;


    public void init ()  //initializing method
    {
	SIN.setBackground (Color.yellow);
	sinamplabel.setBackground (Color.yellow);
	sinperlabel.setBackground (Color.yellow);
	sinhorlabel.setBackground (Color.yellow);
	sinverlabel.setBackground (Color.yellow);
	COS.setBackground (Color.yellow);
	cosamplabel.setBackground (Color.yellow);
	cosperlabel.setBackground (Color.yellow);
	coshorlabel.setBackground (Color.yellow);
	cosverlabel.setBackground (Color.yellow);
	slopexlabel.setBackground (Color.yellow);
	areaxleftlabel.setBackground (Color.yellow);
	areaxrightlabel.setBackground (Color.yellow);



	sinampt = new TextField (5);
	sinpert = new TextField (5);
	sinhort = new TextField (5);
	sinvert = new TextField (5);
	cosampt = new TextField (5);
	cospert = new TextField (5);
	coshort = new TextField (5);
	cosvert = new TextField (5);
	slopext = new TextField (5);
	areaxleftt = new TextField (5);
	areaxrightt = new TextField (5);
	//output = new TextField (5);
	submit = new Button ("Submit");
	add (SIN);
	add (sinamplabel);
	add (sinampt);
	add (sinperlabel);
	add (sinpert);
	add (sinhorlabel);
	add (sinhort);
	add (sinverlabel);
	add (sinvert);
	add (COS);
	add (cosamplabel);
	add (cosampt);
	add (cosperlabel);
	add (cospert);
	add (coshorlabel);
	add (coshort);
	add (cosverlabel);
	add (cosvert);
	add (areaxleftlabel);
	add (areaxleftt);
	add (areaxrightlabel);
	add (areaxrightt);
	add (slopexlabel);
	add (slopext);
	add (submit);
    }


    public boolean action (Event e, Object o)
    {
	try
	{
	    sinamp = Double.parseDouble (sinampt.getText ());
	}
	catch (NumberFormatException ex)
	{
	    sinamp = 1;
	}
	try
	{
	    sinper = Double.parseDouble (sinpert.getText ());
	}
	catch (NumberFormatException ex)
	{
	    sinper = 360;
	}
	try
	{
	    sinhor = Double.parseDouble (sinhort.getText ());
	}
	catch (NumberFormatException ex)
	{
	    sinhor = 0;
	}
	try
	{
	    sinver = Double.parseDouble (sinvert.getText ());
	}
	catch (NumberFormatException ex)
	{
	    sinver = 0;
	}

	try
	{
	    cosamp = Double.parseDouble (cosampt.getText ());
	}
	catch (NumberFormatException ex)
	{
	    cosamp = 1;
	}
	try
	{
	    cosper = Double.parseDouble (cospert.getText ());
	}
	catch (NumberFormatException ex)
	{
	    cosper = 360;
	}
	try
	{
	    coshor = Double.parseDouble (coshort.getText ());
	}
	catch (NumberFormatException ex)
	{
	    coshor = 0;
	}
	try
	{
	    cosver = Double.parseDouble (cosvert.getText ());
	}
	catch (NumberFormatException ex)
	{
	    cosver = 0;
	}
	try
	{
	    slopex = Double.parseDouble (slopext.getText ());
	}
	catch (NumberFormatException ex)
	{
	    slopex = 90;
	}
	try
	{
	    areaxleft = Double.parseDouble (areaxleftt.getText ());
	}
	catch (NumberFormatException ex)
	{
	    areaxleft = 0;
	}
	try
	{
	    areaxright = Double.parseDouble (areaxrightt.getText ());
	}
	catch (NumberFormatException ex)
	{
	    areaxright = 90;
	}
	repaint ();
	return true;
    }


    public void paint (Graphics c)
    {
	c.setColor (Color.yellow);
	c.fillRect (0, 0, 800, 800);

	slope (c);
	drawsin (c);
	drawcos (c);
	drawaxes (c);
	sinzeros (c);
	coszeros (c);
	maxmin (c);
	intersect (c);
	slope (c);
	area (c);


    }


    public void drawaxes (Graphics c)
    {
	c.setColor (Color.black);
	//axes
	c.drawLine (100, 250, 460, 250);
	c.drawLine (100, 100, 100, 400);
	//divisions
	for (int i = 100 ; i <= 460 ; i += 10)
	{
	    c.drawLine (i, 245, i, 255);
	    if ((i) % 90 == 0)
	    {
		c.drawString ("" + (i - 90), i, 265);
	    }
	}


	for (int i = 100 ; i <= 400 ; i += 10)
	{
	    if (i < 250 && (i - 100) % 50 == 0)
	    {
		c.drawString ("" + (5 - i / 50), 82, i + 5);
	    }
	    if (i > 250 && (i - 100) % 50 == 0)
	    {
		c.drawString ("" + (5 - i / 50), 82, i + 5);
	    }

	    c.drawLine (95, i, 105, i);
	}
	c.setColor (Color.red);
	c.fillOval (20, 130, 20, 20);
	c.drawString ("SIN", 47, 143);
	c.setColor (Color.blue);
	c.fillOval (20, 155, 20, 20);
	c.drawString ("COS", 45, 169);



    }


    public double sinvalue (double i)
    {
	double y = (sinamp * (Math.sin ((2 * Math.PI / sinper) * (i - (sinhor)))) + sinver);
	return y;
    }


    public double cosvalue (double i)
    {
	double y = (cosamp * (Math.cos ((2 * Math.PI / cosper) * (i - (coshor)))) + cosver);
	return y;
    }


    public void drawsin (Graphics c)
    {
	c.setColor (Color.red);
	for (double i = 0 ; i <= 360 ; i += 0.1)
	{
	    c.fillOval ((int) i + 100, (int) (250 - (sinvalue (i) * 50)), 1, 1);
	}

    }


    public void drawcos (Graphics c)
    {
	c.setColor (Color.blue);
	for (double i = 0 ; i <= 360 ; i += 0.1)
	{
	    c.fillOval ((int) i + 100, (int) (250 - (cosvalue (i) * 50)), 1, 1);
	}

    }


    public void sinzeros (Graphics c)
    {
	c.setColor (Color.red);
	c.drawString ("ZEROS ", 20, 430);
	c.setColor (Color.blue);
	c.drawString ("SIN  CURVE  ZEROS: ", 100, 430);
	int zerocounter = 0;
	for (double i = 0 ; i < 360 ; i += 0.01)
	{
	    if (Math.abs (sinvalue (i)) < 0.000000001)
	    {
		zerocounter++;
		String zero = "" + (Math.round (i * 100)) / 100;
		c.drawString (zero, 210 + (40 * zerocounter), 430);
	    }
	}
    }


    public void coszeros (Graphics c)
    {
	c.setColor (Color.blue);

	c.drawString ("COS CURVE ZEROS: ", 100, 450);
	int zerocounter = 0;

	for (double i = 0 ; i < 360 ; i += 0.01)
	{
	    if (Math.abs (cosvalue (i)) < 0.0000000001)
	    {
		zerocounter++;
		String zero = "" + (Math.round (i * 100)) / 100;
		c.drawString (zero, 210 + (40 * zerocounter), 450);
	    }
	}
    }


    public void maxmin (Graphics c)
    {

	c.setColor (Color.red);
	c.drawString ("MAX & MIN ", 20, 480);
	c.setColor (Color.blue);
	c.drawString ("SIN MAX: " + (sinamp + sinver), 100, 480);
	c.drawString ("COS MAX: " + (cosamp + cosver), 190, 480);
	c.drawString ("SIN MIN: " + (-1 * sinamp + sinver), 280, 480);
	c.drawString ("COS MIN: " + (-1 * cosamp + cosver), 370, 480);

    }


    public void intersect (Graphics c)
    {

	c.setColor (Color.red);
	c.drawString ("POI ", 20, 510);
	c.setColor (Color.blue);

	int horshift = 0;
	c.drawString ("CURVES INTERSECT AT: ", 100, 510);

	for (double i = 0 ; i < 360 ; i += 0.01)
	{
	    if (Math.abs (sinvalue (i) - cosvalue (i)) < 0.0001)
	    {
		c.drawString ("(" + Math.round (i) + "," + Math.round (sinvalue (i)) + ")", 250 + horshift, 510);
		horshift += 50;

	    }
	}
    }


    public void slope (Graphics c)
    {
	c.setColor (Color.red);
	c.drawString ("SLOPES ", 20, 540);
	c.setColor (Color.blue);
	sinslope = sinamp * Math.cos ((2 * Math.PI / sinper) * (slopex - (sinhor)));
	sinslope = Math.round (sinslope * 100.0) / 100.0;
	cosslope = -1 * cosamp * Math.sin ((2 * Math.PI / cosper) * (slopex - (coshor)));
	cosslope = Math.round (cosslope * 100.0) / 100.0;
	c.drawString ("SIN SLOPE AT " + slopex + "= " + sinslope, 100, 540);
	c.drawString ("COS SLOPE AT " + slopex + "= " + cosslope, 100, 560);
    }


    public void area (Graphics c)
    {
	c.setColor (Color.red);
	c.drawString ("AREAS ", 20, 590);
	double areasin = 0, areacos = 0;
	for (double i = areaxleft ; i <= areaxright ; i += 0.001)
	{
	    areasin += (0.001 * sinvalue (i));
	    if ((int) i % 2 == 0)
	    {
		c.setColor (Color.red);
		c.drawLine ((int) i + 100, 250, (int) i + 100, (int) (250 - (50 * sinvalue (i))));
	    }
	    if ((int) i % 2 == 0)
	    {
		c.setColor (Color.blue);
		c.drawLine ((int) i + 101, 250, (int) i + 101, (int) (250 - (50 * cosvalue (i))));

	    }

	    areacos += (0.001 * cosvalue (i));
	}
	areasin = Math.round (Math.toRadians (areasin) * 100.0) / 100.0;
	areacos = Math.round (Math.toRadians (areacos) * 100.0) / 100.0;
	c.setColor (Color.blue);

	c.drawString ("NET AREA UNDER SIN CURVE IN [" + areaxleft + "," + areaxright + "] is " + (areasin), 100, 590);
	c.drawString ("NET AREA UNDER COS CURVE IN [" + areaxleft + "," + areaxright + "] is " + (areacos), 100, 610);

    }
}

