package com.mycompany.projetf1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import javax.swing.JPanel;

public class TrackPanel extends JPanel {
    
    private List<Location> locations;

    public void setLocations(List<Location> locations) {
        this.locations = locations;
        this.repaint(); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (locations == null || locations.isEmpty()) return;

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(Color.RED); 
        g2d.setStroke(new BasicStroke(3)); 

        double minX = Double.MAX_VALUE, maxX = -Double.MAX_VALUE;
        double minY = Double.MAX_VALUE, maxY = -Double.MAX_VALUE;

        for (Location loc : locations) {
            if (loc.getX() != null && loc.getY() != null) {
                minX = Math.min(minX, loc.getX());
                maxX = Math.max(maxX, loc.getX());
                minY = Math.min(minY, loc.getY());
                maxY = Math.max(maxY, loc.getY());
            }
        }

        double width = getWidth() - 20;  
        double height = getHeight() - 20;
        double scaleX = width / (maxX - minX);
        double scaleY = height / (maxY - minY);
        double scale = Math.min(scaleX, scaleY); 

        Location prev = null;
        for (Location loc : locations) {
            if (loc.getX() != null && loc.getY() != null) {
                if (prev != null) {
                    int x1 = 10 + (int) ((prev.getX() - minX) * scale);
                    int y1 = 10 + (int) ((prev.getY() - minY) * scale);
                    int x2 = 10 + (int) ((loc.getX() - minX) * scale);
                    int y2 = 10 + (int) ((loc.getY() - minY) * scale);
                    
                    g2d.drawLine(x1, y1, x2, y2); 
                }
                prev = loc;
            }
        }
    }
}