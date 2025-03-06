
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
        
        try {
            if (this.img == null) {
              this.img = ImageIO.read(getClass().getResource(img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    //TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      
      ArrayList<Square> controlledSquares = new ArrayList<Square>();

      //to the right in a column
      for (int i = 1; i < 8; i++) {
          if (start.getCol() + i < 8) {
              Square currSquare = board[start.getRow()][start.getCol() + i];
              if (currSquare.isOccupied()) {
                  if (currSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()) {
                      controlledSquares.add(currSquare);
                  }
                  break;
              }
              controlledSquares.add(currSquare);
          } 
          else {
            break;
          }
      }
  
      //to the left in a column
      for (int i = 1; i < 8; i++) {
          if (start.getCol() - i >= 0) {
              Square currSquare = board[start.getRow()][start.getCol() - i];
              if (currSquare.isOccupied()) {
                  if (currSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()) {
                      controlledSquares.add(currSquare);
                  }
                  break;
              }
              controlledSquares.add(currSquare);
          } 
          else {
            break;
          }
      }
  
      //down in rows
      for (int i = 1; i < 8; i++) {
          if (start.getRow() + i < 8) {
              Square currSquare = board[start.getRow() + i][start.getCol()];
              if (currSquare.isOccupied()) {
                  if (currSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()) {
                      controlledSquares.add(currSquare);
                  }
                  break;
              }
              controlledSquares.add(currSquare);
          } 
          else {
            break;
          }
      }
  
      //up in rows
      for (int i = 1; i < 8; i++) {
          if (start.getRow() - i >= 0) {
              Square currSquare = board[start.getRow() - i][start.getCol()];
              if (currSquare.isOccupied()) {
                  if (currSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()) {
                      controlledSquares.add(currSquare);
                  }
                  break;
              }
              controlledSquares.add(currSquare);
          } 
          else {
            break;
          }
      }
      return controlledSquares;
  }
  
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.

    //the piece is a rook with a bomb (rook rocket), it moves like a normal rook but has a 15% chance of exploding and 
    //destroying itself and the 8 pieces around it
    public ArrayList<Square> getLegalMoves(Board b, Square start) {
    ArrayList<Square> moves = new ArrayList<Square>();

    for (int i = 1; i < 8; i++) {
        if (start.getCol() + i < 8) {
            Square currSquare = b.getSquareArray()[start.getRow()][start.getCol() + i];
            if (currSquare.getOccupyingPiece() != null) {
                if (start.getOccupyingPiece().getColor() != currSquare.getOccupyingPiece().getColor()) {
                    moves.add(currSquare); 
                }
                break; 
            }
            moves.add(currSquare);
        } 
        else {
          break;
        }
    }

    for (int i = 1; i < 8; i++) {
        if (start.getCol() - i >= 0) {
            Square currSquare = b.getSquareArray()[start.getRow()][start.getCol() - i];
            if (currSquare.getOccupyingPiece() != null) {
                if (start.getOccupyingPiece().getColor() != currSquare.getOccupyingPiece().getColor()) {
                    moves.add(currSquare);
                }
                break;
            }
            moves.add(currSquare);
        } 
        else {
          break;
        }
    }

    // Moving down
    for (int i = 1; i < 8; i++) {
        if (start.getRow() + i < 8) {
            Square currSquare = b.getSquareArray()[start.getRow() + i][start.getCol()];
            if (currSquare.getOccupyingPiece() != null) {
                if (start.getOccupyingPiece().getColor() != currSquare.getOccupyingPiece().getColor()) {
                    moves.add(currSquare);
                }
                break;
            }
            moves.add(currSquare);
        } 
        else {
          break;
        }
    }

    for (int i = 1; i < 8; i++) {
        if (start.getRow() - i >= 0) {
            Square currSquare = b.getSquareArray()[start.getRow() - i][start.getCol()];
            if (currSquare.getOccupyingPiece() != null) {
                if (start.getOccupyingPiece().getColor() != currSquare.getOccupyingPiece().getColor()) {
                    moves.add(currSquare);
                }
                break;
            }
            moves.add(currSquare);
        } 
        else {
          break;
        }
    }

    return moves;
}

}