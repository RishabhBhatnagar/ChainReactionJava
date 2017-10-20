
package chainReaction;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public interface IntSketchBoard {
    Graphics g = new Graphics() {
        public Graphics create() {
            return null;
        }

        public void translate(int x, int y) {
        }

        public Color getColor() {
            return null;
        }

        public void setColor(Color c) {
        }

        public void setPaintMode() {
        }

        public void setXORMode(Color c1) {
        }

        public Font getFont() {
            return null;
        }

        public void setFont(Font font) {
        }

        public FontMetrics getFontMetrics(Font f) {
            return null;
        }

        public Rectangle getClipBounds() {
            return null;
        }

        public void clipRect(int x, int y, int width, int height) {
        }

        public void setClip(int x, int y, int width, int height) {
        }

        public Shape getClip() {
            return null;
        }

        public void setClip(Shape clip) {
        }

        public void copyArea(int x, int y, int width, int height, int dx, int dy) {
        }

        public void drawLine(int x1, int y1, int x2, int y2) {
        }

        public void fillRect(int x, int y, int width, int height) {
        }

        public void clearRect(int x, int y, int width, int height) {
        }

        public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        }

        public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        }

        public void drawOval(int x, int y, int width, int height) {
        }

        public void fillOval(int x, int y, int width, int height) {
        }

        public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        }

        public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        }

        public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
        }

        public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        }

        public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        }

        public void drawString(String str, int x, int y) {
        }

        public void drawString(AttributedCharacterIterator iterator, int x, int y) {
        }

        public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
            return false;
        }

        public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
            return false;
        }

        public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
            return false;
        }

        public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
            return false;
        }

        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
            return false;
        }

        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
            return false;
        }

        public void dispose() {
        }
    };
}
