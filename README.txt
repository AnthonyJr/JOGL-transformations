Anthony Snow 
CS335 
10/2/2016

Main function located in the HelloOpenGL.java file.

JoglEventListeners hosts all of the transformation to the UK logo. 

public void display(GLAutoDrawable gLDrawable){

	This function hosts the uk logo. Anything that is 
	changed about the logo will be changed in here. 
	
}

public void keyTyped(KeyEvent e){

	This function hosts what happens when certain keys are typed. 
	
	's': Initializes scaling
	'r': initializes rotation 
	't': initializes translation 
	'g': increases focal Length 
	'h': Decreases focal length 
	'0': resets logo
	

}

public void mouseDragged(MouseEvent e){

	Depending on which interaction is chosen,
	(rotation,scale, translation) the mouse drag 
	will perform that action.  	

}