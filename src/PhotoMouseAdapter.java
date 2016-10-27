import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PhotoMouseAdapter extends MouseAdapter{
	PhotoComponent photoComponent = null;
	PhotoBrowser photoBrowser = null;
	public PhotoMouseAdapter(PhotoComponent pc,PhotoBrowser pb) {
		// TODO Auto-generated constructor stub
		photoComponent = pc;
		photoBrowser = pb;
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		super.mouseClicked(e);
		if(e.getClickCount() == 2){
			photoComponent.flipped = !photoComponent.flipped;
			photoComponent.init();
			photoBrowser.setStatusMes("Fliping "+photoComponent.flipped);
			if (photoComponent.flipped) {			
				photoBrowser.imageToolBar.setVisible(true);;
			}else{
				photoBrowser.imageToolBar.setVisible(false);
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent m) {
		// TODO mouse in
		photoBrowser.setStatusMes("mouse entred position: ["+m.getX()+","+m.getY()+"]");
	}

	@Override
	public void mouseExited(MouseEvent m) {
		// TODO mouse out
	}

	@Override
	public void mousePressed(MouseEvent m) {
		photoComponent.requestFocus();
		// TODO mouse pressed
		photoBrowser.setStatusMes("mouse pressed position: ["+m.getX()+","+m.getY()+"]");
		
		if(photoComponent.flipped){
			photoComponent.createNewDraw();

			photoComponent.stroke.initPosition.x = m.getX();
			photoComponent.stroke.finalPosition.x = m.getX();
			photoComponent.stroke.initPosition.y = m.getY();
			photoComponent.stroke.finalPosition.y = m.getY();
			
			if (photoComponent.currentChoice == 5 || photoComponent.currentChoice == 6) {
				photoComponent.stroke.path2d.moveTo(m.getX(), m.getY());
			}

			photoComponent.updateStrokeParameters();
			
			photoComponent.strokeList.add(photoComponent.stroke);
			photoComponent.repaint();
			photoComponent.index++;	

		}

	}

	@Override
	public void mouseReleased(MouseEvent m) {
		// TODO mouse released
		photoBrowser.setStatusMes("mouse released position ["+m.getX()+","+m.getX()+"]");

	}

	@Override
	public void mouseDragged(MouseEvent m)// mouse dragged 
	{
		photoBrowser.setStatusMes("mouse dragged position [" + m.getX() + " ," + m.getY() + "]");
		if(photoComponent.flipped){
			if (photoComponent.currentChoice == 5 || photoComponent.currentChoice == 6) {
				photoComponent.stroke.path2d.lineTo(m.getX(), m.getY());
				
			}else {
				photoComponent.stroke.finalPosition.x = m.getX();
				photoComponent.stroke.finalPosition.y = m.getY();

			}


			photoComponent.repaint();
		}
	}

	public void mouseMoved(MouseEvent m)// mouse move
	{
		photoBrowser.setStatusMes("mouse position£∫[" + m.getX() + " ," + m.getY() + "]");
	}


}

