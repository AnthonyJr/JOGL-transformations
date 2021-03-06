package HW2;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.nio.DoubleBuffer;

import com.jogamp.opengl.*;
import com.jogamp.opengl.glu.GLU;




public class JoglEventListener implements GLEventListener, KeyListener, MouseListener, MouseMotionListener {
	
	float[] vertices={5.97994f, -0.085086f, -0.010798f, 
			5.97994f, 10.0043f, -0.010798f, 
			7.99077f, 10.0043f, -0.010798f, 
			7.99077f, 11.3449f, -0.010798f, 
			-0.405339f, 11.3449f, -0.010798f, 
			-0.405339f, 9.98083f, -0.010798f, 
			1.65252f, 9.98083f, -0.010798f, 
			1.65252f, 0.549879f, -0.010798f, 
			-0.722839f, 0.549879f, -0.010798f, 
			-0.722839f, -1.69612f, -0.010798f, 
			2.6168f, -1.69612f, -0.010798f, 
			-7.24925f, 0.42055f, -0.010798f, 
			-9.35415f, 0.42055f, -0.010798f, 
			-9.35415f, 10.0043f, -0.010798f, 
			-7.37859f, 10.0043f, -0.010798f, 
			-7.37859f, 11.3802f, -0.010798f, 
			-15.8217f, 11.3802f, -0.010798f, 
			-15.8217f, 9.99258f, -0.010798f, 
			-13.8109f, 9.99258f, -0.010798f, 
			-13.8109f, -0.061591f, -0.010798f, 
			-10.2361f, -1.73139f, -0.010798f, 
			-7.26099f, -1.73139f, -0.010798f, 
			-6.1909f, 0.855631f, -0.010798f, 
			-8.11942f, 0.855631f, -0.010798f, 
			-8.11942f, 2.31379f, -0.010798f, 
			0.217914f, 2.31379f, -0.010798f, 
			0.217914f, 0.926204f, -0.010798f, 
			-1.73415f, 0.926204f, -0.010798f, 
			-1.73415f, -4.10675f, -0.010798f, 
			9.23724f, 0.937952f, -0.010798f, 
			7.26169f, 0.937952f, -0.010798f, 
			7.26169f, 2.38434f, -0.010798f, 
			15.6696f, 2.38434f, -0.010798f, 
			15.6696f, 1.00851f, -0.010798f, 
			14.964f, 1.00851f, -0.010798f, 
			7.75558f, -2.44873f, -0.010798f, 
			14.4231f, -9.36318f, -0.010798f, 
			16.0576f, -9.36318f, -0.010798f, 
			16.0576f, -10.6685f, -0.010798f, 
			7.62625f, -10.6685f, -0.010798f, 
			7.62625f, -9.33965f, -0.010798f, 
			9.67236f, -9.33965f, -0.010798f, 
			4.49827f, -3.90687f, -0.010798f, 
			-1.35784f, -6.59973f, -0.010798f, 
			-1.35784f, -9.3279f, -0.010798f, 
			0.217914f, -9.3279f, -0.010798f, 
			0.217914f, -10.6919f, -0.010798f, 
			-8.22526f, -10.6919f, -0.010798f, 
			-8.22526f, -9.32786f, -0.010798f, 
			-6.20266f, -9.32786f, -0.010798f};
	int[] indices={3, 2, 3, 1, 
			3, 1, 3, 6, 
			3, 1, 6, 10, 
			3, 10, 6, 7, 
			3, 10, 7, 8, 
			3, 4, 5, 6, 
			3, 4, 6, 3, 
			3, 10, 8, 9, 
			3, 1, 10, 0, 
			3, 13, 14, 15, 
			3, 13, 15, 18, 
			3, 13, 18, 20, 
			3, 13, 20, 12, 
			3, 16, 17, 18, 
			3, 16, 18, 15, 
			3, 12, 20, 21, 
			3, 12, 21, 11, 
			3, 20, 18, 19, 
			3, 49, 22, 44, 
			3, 44, 22, 28, 
			3, 44, 28, 43, 
			3, 43, 28, 29, 
			3, 43, 29, 42, 
			3, 42, 29, 35, 
			3, 42, 35, 41, 
			3, 41, 35, 36, 
			3, 41, 36, 38, 
			3, 38, 36, 37, 
			3, 39, 40, 41, 
			3, 39, 41, 38, 
			3, 29, 30, 32, 
			3, 29, 32, 34, 
			3, 29, 34, 35, 
			3, 46, 47, 49, 
			3, 46, 49, 44, 
			3, 46, 44, 45, 
			3, 22, 23, 25, 
			3, 22, 25, 27, 
			3, 22, 27, 28, 
			3, 25, 23, 24, 
			3, 27, 25, 26, 
			3, 49, 47, 48, 
			3, 32, 30, 31, 
			3, 34, 32, 33};
	float backrgb[] = new float[4]; 
	double rot; 
	
	/*
	 * Custom variables for mouse drag operations 
	 */
	
	int windowWidth, windowHeight;
	float orthoX=40;
	float tVal_x, tVal_y, rVal_x, rVal_y, rVal;
	double rtMat[] = new double[16];
	int saveRTnow=0, mouseDragButton=0;
	boolean translation = false; 
	boolean scaling = false; 
	boolean rotation = false; 
	boolean rightButton = false; 
	
	float focalLength = 10.0f;
	float r11 = 1.0f, r12 = 0.0f, r13 = 0.0f, tx = 0.0f,
	      r21 = 0.0f, r22 = 1.0f, r23 = 0.0f, ty = 0.0f,
	      r31 = 0.0f, r32 = 0.0f, r33 = 1.0f, tz = 0.0f;
	float mouseX0, mouseY0;


    private GLU glu = new GLU();

	
	 public void displayChanged(GLAutoDrawable gLDrawable, 
	            boolean modeChanged, boolean deviceChanged) {
	    }

	    /** Called by the drawable immediately after the OpenGL context is
	     * initialized for the first time. Can be used to perform one-time OpenGL
	     * initialization such as setup of lights and display lists.
	     * @param gLDrawable The GLAutoDrawable object.
	     */
	    public void init(GLAutoDrawable gLDrawable) {
	        GL2 gl = gLDrawable.getGL().getGL2();
	        //gl.glShadeModel(GL.GL_LINE_SMOOTH);              // Enable Smooth Shading
	        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);    // Black Background
	        gl.glClearDepth(1.0f);                      // Depth Buffer Setup
	        gl.glEnable(GL.GL_DEPTH_TEST);              // Enables Depth Testing
	        gl.glDepthFunc(GL.GL_LEQUAL);               // The Type Of Depth Testing To Do
	        // Really Nice Perspective Calculations
	        //gl.glHint(GL.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);

	        gl.glMatrixMode(GL2.GL_MODELVIEW);
	        gl.glLoadIdentity();
	        
	        
	        
	    }


	    
	    public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, 
	            int height) {
	    	windowWidth = width;
	    	windowHeight = height;
	        final GL2 gl = gLDrawable.getGL().getGL2();

	        if (height <= 0) // avoid a divide by zero error!
	            height = 1;
	        final float h = (float) width / (float) height;
	        gl.glViewport(0, 0, width, height);
	        gl.glMatrixMode(GL2.GL_PROJECTION);
	        gl.glLoadIdentity();
	       gl.glOrtho(-orthoX*0.5, orthoX*0.5, -orthoX*0.5*height/width, orthoX*0.5*height/width, -100, 100);
	       //glu.gluPerspective(45.0f, h, 1, 100000.0);

	    }
	    
	    public void project(float[] vertices_in, float[] vertices_out) {
	    
	        
	    	float[] projMatrix = 
		    	{
		    	   r11, r12, r13, tx,
		    	   r21, r22, r23, ty,
		    	   r31, r32, r33, tz,
		    	   0,   0,   1.0f/focalLength, 1
		    	};
		    	
		    	for(int i = 0; i < vertices_in.length; i += 3){
		    		float tempZ = vertices_in[i+2] + 10;  // this translation in Z is needed to pull the camera away from the object. 
		    		// don't change the above line unless you are sure about what you are doing.
		    		
		    		vertices_out[i] = (projMatrix[0] * vertices_in[i] + projMatrix[1] * vertices_in[i + 1] + projMatrix[2] * tempZ + projMatrix[3]);
		    		vertices_out[i + 1] = projMatrix[4] * vertices_in[i] + projMatrix[5] * vertices_in[i + 1] + projMatrix[6] * tempZ+ projMatrix[7];
		    		vertices_out[i + 2] = projMatrix[8] * vertices_in[i] + projMatrix[9] * vertices_in[i + 1] + projMatrix[10] * tempZ+ projMatrix[11];
		    	   
		    		float temp = projMatrix[12] * vertices_in[i] + projMatrix[13] * vertices_in[i + 1] + projMatrix[14] * tempZ+ projMatrix[15];
		    	   
		    	    vertices_out[i]   = vertices_out[i]   / temp;
		    	    vertices_out[i+1] = vertices_out[i+1] / temp;
		    	    vertices_out[i+2] = vertices_out[i+2] / temp;
	    	
		    	}
	    }
	    
	    public void transform(float[] vertices_in, float[] vertices_out){
	    	
	    	// perform your transformation
	    
	    	int length = vertices_in.length;
	    	float[] transformMatrix = 
		    	{
		    	   r11, r12, r13, tx,
		    	   r21, r22, r23, ty,
		    	   r31, r32, r33, tz,
		    	   0,   0,   0, 1
		    	};
	    	
	    	
	    	
	    	
	    	

	    	

	    	
	    }

		@Override
		public void display(GLAutoDrawable gLDrawable) {
			// TODO Auto-generated method stub
			final GL2 gl = gLDrawable.getGL().getGL2();

			gl.glClearColor(backrgb[0], 0, 1, 1);
			gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		
			
	    	gl.glMatrixMode(GL2.GL_MODELVIEW);
	    	gl.glLoadIdentity();
	 	
			float[] vertices_new = new float[vertices.length];

			// call the transform function here
			// transform(...)
			transform(vertices,vertices_new);
			
			project(vertices, vertices_new);
	        
			gl.glBegin(GL.GL_TRIANGLES);        // Drawing Using Triangles
        	for(int i=0; i<44; i++) {
        		gl.glColor3f(0.7f, 0.7f, 0.7f);
        		
        		gl.glVertex3f(vertices_new[(indices[i*4+1])*3],
        				vertices_new[(indices[i*4+1])*3+1],
        				vertices_new[(indices[i*4+1])*3+2]);
        		gl.glVertex3f(vertices_new[(indices[i*4+2])*3],
        				vertices_new[(indices[i*4+2])*3+1],
        				vertices_new[(indices[i*4+2])*3+2]);
        		gl.glVertex3f(vertices_new[(indices[i*4+3])*3],
        				vertices_new[(indices[i*4+3])*3+1],
        				vertices_new[(indices[i*4+3])*3+2]);
        		
        		
    			
        		
        		
        		
        		/*gl.glVertex3f(vertices[(indices[i*4+1])*3],
        					  vertices[(indices[i*4+1])*3+1],
        					  vertices[(indices[i*4+1])*3+2]);
        		gl.glVertex3f(vertices[(indices[i*4+2])*3],
  					  		  vertices[(indices[i*4+2])*3+1],
  					  		  vertices[(indices[i*4+2])*3+2]);
        		gl.glVertex3f(vertices[(indices[i*4+3])*3],
  					  		  vertices[(indices[i*4+3])*3+1],
  					  		  vertices[(indices[i*4+3])*3+2]);*/
        	}
	        gl.glEnd();                         // Finished Drawing The Triangle
	        
			
		}

		@Override
		public void dispose(GLAutoDrawable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		    char key= e.getKeyChar();
			System.out.printf("Key typed: %c\n", key); 
			
			switch (key){
			
			case 's': 
				System.out.println("initiazlizing Scaling....");
				scaling = true;
				translation = false; 
				rotation = false; 
				break; 
			case 't': 
				System.out.println("Initializing Translation....");
				translation = true; 
				scaling = false; 
				rotation = false; 
				break; 
				
			case 'r': 
				System.out.println("Initialzing Rotation...");
				rotation = true; 
				scaling = false; 
				translation = false; 
				break; 
			
			case 'g': 
				System.out.println("Increasing Focal Length");
				focalLength++; 
				break; 
				
			case 'h': 
				System.out.println("Decreasing Focal Length");
				focalLength--;
				break;
			
			case '0': 
				tx = 0; ty = 0; tz = 0;
				r11 = 1; r12 = 0; r13 = 0; 
				r21 = 0; r22 = 1; r23 = 0; 
				r31 = 0; r32 = 0; r33 = 1;  
				rightButton = false; 
				rotation = false; 
				translation = false; 
				scaling = false;
				break;
			}


		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
			
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
			
				
			
		}

		@Override 
		public void mouseDragged(MouseEvent e) {
			rot+=.05;
			float XX = (e.getX()-windowWidth*0.5f)*orthoX/windowWidth;
			float YY = -(e.getY()-windowHeight*0.5f)*orthoX/windowWidth;
			
			if (translation == true){
				tx = XX; 
				ty = YY;
			} else if (scaling == true){
				if (mouseX0 < XX){
					r11+=.05; 
					r22+=.05; 
					r33+=.05;
				} else if (mouseX0 > XX){
					r11-=.05; 
					r22-=.05; 
					r33-=.05; 
				}
				
				
			}  else if (rotation == true && rightButton == false){
				
				/////About X-axis
				if (mouseX0 < XX){
					r11 = 1; r12 = 0; r13 = 0; tx = 0; 
					r21 = 0; r22 = (float) Math.cos(rot); r23 = (float) -Math.sin(rot); ty = 0; 
					r31 = 0; r32 = (float) Math.sin(rot); r33 = (float) Math.cos(rot); tz = 0; 
					
				} else if (mouseX0 > XX){
					//reverse reverse 
					r11 = 1; r12 = 0; r13 = 0; tx = 0; 
					r21 = 0; r22 = (float) Math.cos(rot); r23 = (float) Math.sin(rot); ty = 0; 
					r31 = 0; r32 = (float) Math.sin(rot); r33 = (float) Math.cos(rot); tz = 0; 
				} 
				////About the X-axis
				
				
				//// About the Y-axis*************************************************************************************************************************
				if (mouseY0 < YY){
					r11 = (float) Math.cos(rot); r12 = 0; r13 = (float) Math.sin(rot);
					r21 = 0; r22 = 1; r23 = 0; 
					r31 = (float) -Math.sin(rot); r32 = 0; r33 = (float) Math.cos(rot); 
				} else if (mouseY0 > YY ){
					System.out.println("in");
					//reverse reverse
					r11 = (float) -Math.cos(rot); r12 = 0; r13 =  (float) -Math.sin(rot);
					r21 = 0; r22 = 1; r23 = 0; 
					r31 = (float) Math.sin(rot); r32 = 0; r33 = (float) Math.cos(rot); 
				} 
				/////About the Y-axis************************************************************************************************************************
				
				
				
			}
			
			else if (rotation == true && rightButton == true){
				System.out.println("In");
				if (mouseX0 < XX){
					r11 = (float) Math.cos(rot); r12 = (float) -Math.sin(rot); r13 = 0; 
					r21 = (float) Math.sin(rot); r22 = (float) Math.cos(rot); r33 = 0; ;
					r31 = 0; r32 = 0; r33 = 1; 
				} else if (mouseX0 > XX){
					r11 = (float) -Math.cos(rot); r12 = (float) -Math.sin(rot); r13 = 0; 
					r21 = (float) Math.sin(rot); r22 = -(float) Math.cos(rot); r33 = 0; ;
					r31 = 0; r32 = 0; r33 = 1; 
				}
			}
			
			
			
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			/*
			 * Coordinates printout
			 */
			float XX = (e.getX()-windowWidth*0.5f)*orthoX/windowWidth;
			float YY = -(e.getY()-windowHeight*0.5f)*orthoX/windowWidth;
			mouseX0 = XX; 
			mouseY0 = YY; 
			System.out.printf("Point clicked: (%.3f, %.3f)\n", XX, YY);
			

			if(e.getButton()==MouseEvent.BUTTON1) {	// Left button
				
			}
			else if(e.getButton()==MouseEvent.BUTTON3) {	// Right button
				System.out.println("Right Mouse Button Clicked");
				rightButton = true; 
							}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	  /*  
	public void init(GLDrawable gLDrawable) {
		final GL gl = glDrawable.getGL();
        final GLU glu = glDrawable.getGLU();

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-1.0f, 1.0f, -1.0f, 1.0f); // drawing square
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }*/
	
}



