/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package harmoniaphilosophica.com.huochess09923;

import java.util.Scanner;
/**
 *
 * @author skako
 */
public class HuoChess09923 {

// Huo Chess by Spiros Kakos (2018)
// License: Reuse the code as you please, as long as you mention the author and where you first read it!
    
// Declare variables

// Player color
public static String m_PlayerColor;
// Who plays
public static String m_WhoPlays;
// Move related variables
public static String playerMove;
public static String movingPiece;
public static String startingColumn;
public static String startingRank;
public static String finishingColumn;
public static String finishingRank;
public static int startingRankNum;
public static int finishingRankNum;
public static int startingColumnNum;
public static int finishingColumnNum;
public static boolean moveValidity;
public static boolean moveLegality;
// Additional variables for check legality of move
public static int p, h;
public static int how_to_move_Rank = 0;
public static int how_to_move_Column = 0;
public static boolean m_WrongColumn;
public static boolean exit_elegxos_nomimothtas;
public static boolean enpassant_occured;
public static String ProsorinoKommati_KingCheck;
public static boolean WhiteKingCheck;
public static boolean BlackKingCheck;
public static int WhiteKingColumn;
public static int WhiteKingRank;
public static int BlKingColumn;
public static int BlKingRank;        
public static boolean DangerFromRight;
public static boolean DangerFromLeft;
public static boolean DangerFromUp;
public static boolean DangerFromDown;
public static boolean DangerFromUpRight;
public static boolean DangerFromDownLeft;
public static boolean DangerFromDownRight;
public static boolean DangerFromUpLeft;
// Variables to store the best move
public static boolean bestMoveFound;
public static int Best_Move_StartingColumnNumber;
public static int Best_Move_StartingRank;
public static int Best_Move_FinishingColumnNumber;
public static int Best_Move_FinishingRank;
// Variables to store the score
public static double tempScore;
public static double bestScore;
// The chessboard
//public static String[][] Skakiera = new String[8][8];
public static String[][] drawChessBoard = new String[8][8];
// The tool used to read the input from the user
static Scanner reader = new Scanner(System.in);

//v0.992
public static int Move_Number_Global;

////////////////////////////////////////////////////////////////////////////////////////////////////////
// DECLARE VARIABLES (v0.970: Sanitization)
////////////////////////////////////////////////////////////////////////////////////////////////////////

//C# TO JAVA CONVERTER WARNING: The java.io.OutputStreamWriter constructor does not accept all the arguments passed to the System.IO.StreamWriter constructor:
//ORIGINAL LINE: public static StreamWriter huo_sw1 = new StreamWriter("Minimax_Thought_Process.txt", true);
//		public static OutputStreamWriter huo_sw1 = new OutputStreamWriter("Minimax_Thought_Process.txt");
//C# TO JAVA CONVERTER WARNING: The java.io.OutputStreamWriter constructor does not accept all the arguments passed to the System.IO.StreamWriter constructor:
//ORIGINAL LINE: public static StreamWriter huo_sw_attackers = new StreamWriter("Attackers.txt", true);
//		public static OutputStreamWriter huo_sw_attackers = new OutputStreamWriter("Attackers.txt");

// New writers for logging the attackers, the defenders and the dangerous squares
//public static StreamWriter huo_sw_defenders = new StreamWriter("Defenders.txt", true);
//public static StreamWriter huo_sw_dangerous = new StreamWriter("Dangerous.txt", true);

public static String NextLine;
public static String FinalPositions;

//v0.990
public static String ThisIsStupidMove = "N";
public static boolean Danger_for_piece;
public static boolean ThereIsCheck;
//Is it possible to eat a piece of greater value?
public static boolean possibility_to_eat;
public static int ValueOfKommati = 0;
public static int ValueOfTargetPiece = 0;
// Chessboard for logging purposes
public static String[][] SkakieraLog = new String[8][8]; // Δήλωση πίνακα που αντιπροσωπεύει τη σκακιέρα

//v0.980: Change small Strings to Int
//0 = Not dangerous square
//1 = Dangerous square
public static int[][] Skakiera_Dangerous_Squares = new int[8][8];
//v0.990: New dangerous squares check to see if the computer moves his pieve into a square,
//where the only defender was the same moving piece! (and there exists an attacker of course...)
//public static int[,] Skakiera_Dangerous_Squares_2 = new int[8, 8];
public static int[][] Number_of_defenders = new int[8][8];
public static int[][] Number_of_attackers = new int[8][8];
//v0.980: Removed Attackers_coordinates_column/ rank since they are not used!
//public static int[,] Attackers_coordinates_column = new int[8, 8];
//public static int[,] Attackers_coordinates_rank = new int[8, 8];
public static int[][] Value_of_defenders = new int[8][8];
public static int[][] Value_of_attackers = new int[8][8];
//v0.980: Removed Exception_defender_column/ rank since they are not used!
//public static int[,] Exception_defender_column = new int[8, 8];
//public static int[,] Exception_defender_rank = new int[8, 8];

// Parameter which determined the weight of danger in the counting of the score of positions
//v0.980: Removed humanDangerParameter and computerDangerParameter
//public static int humanDangerParameter = 0;
//public static int computerDangerParameter = 1;

// Is it possible to eat back the piece that was moved by the computer?
public static boolean possibility_to_eat_back;

//v0.970 added
public static int ValueOfHumanMovingPiece = 0;
public static int ValueOfMovingPiece = 0;

// Variables to store the scores of positions during the analysis
//v0.970: Changed them to integers
public static int Temp_Score_Move_0;
public static int Temp_Score_Move_1_human;
public static int Temp_Score_Move_2;
public static int Temp_Score_Move_3_human;
public static int Temp_Score_Move_4;
public static int Temp_Score_Move_5_human;
public static int Temp_Score_Move_6;

// 0.970
// These arrays will hold the Minimax analysis nodes data (skakos)
// Dimension ,1: For the score
// Dimension ,2: For the parent
// Dimensions 3-6: For the initial move starting/ finishing columns-ranks (only for the 0-level array)
// Changed them to integers for less memory usage
//v0.980: Reduced size of arrays
public static int[][] NodesAnalysis0 = new int[1000000][6];
public static int[][] NodesAnalysis1 = new int[1000000][2];
public static int[][] NodesAnalysis2 = new int[1000000][2];
public static int[][] NodesAnalysis3 = new int[10000000][2];
public static int[][] NodesAnalysis4 = new int[10000000][2];
// v0.990 Move 4 changes
// These variables cannot be activated.
// If they are activated, the program does not start.
// (a memory limitation problem?)
//		public static int[][] NodesAnalysis3 = new int[10000000][2];
//		public static int[][] NodesAnalysis4 = new int[100000000][2]; // Increased depth => Increased size (logical...)

//		public static String[] NodesAnalysis0_Move = new String[1000000]; //v0.990
//		public static String[] NodesAnalysis1_Move = new String[1000000]; //v0.990
//		public static String[] NodesAnalysis2_Move = new String[1000000]; //v0.990
//																		   //public static String[] NodesAnalysis3_Move = new String[1000000];  //v0.990
//																		   //public static String[] NodesAnalysis4_Move = new String[1000000];  //v0.990
//		public static String[][][] NodesAnalysis0_Chessboard = new String[8][8][1000000]; //v0.990
//		public static String[][][] NodesAnalysis1_Chessboard = new String[8][8][1000000]; //v0.990
//		public static String[][][] NodesAnalysis2_Chessboard = new String[8][8][1000000]; //v0.990
//		public static String[][][] NodesAnalysis2_Chessboard_2 = new String[8][8][1000000]; //v0.990
//		public static String[][][] NodesAnalysis4_Chessboard_4 = new String[8][8][1000000]; //v0.990
//																						   //public static String[,,] NodesAnalysis3_Chessboard = new String[8, 8, 1000000];  //v0.990
//																						   //public static String[,,] NodesAnalysis4_Chessboard = new String[8, 8, 1000000];  //v0.990
//		public static String[][][] NodesAnalysis0_Chessboard_before = new String[8][8][1000000]; //v0.990
//		public static String[][][] NodesAnalysis1_Chessboard_before = new String[8][8][1000000]; //v0.990
//		public static String[][][] NodesAnalysis2_Chessboard_before = new String[8][8][1000000]; //v0.990
//																								//public static String[,,] NodesAnalysis3_Chessboard_before = new String[8, 8, 1000000];  //v0.990
                                                                                                                                                                                //public static String[,,] NodesAnalysis4_Chessboard_before = new String[8, 8, 1000000];  //v0.990
                                                                                                                                                                                //public static int[,] NodesAnalysis3 = new int[1000000, 2];

public static int Nodes_Total_count;
public static int NodeLevel_0_count;
public static int NodeLevel_1_count;
public static int NodeLevel_2_count;
public static int NodeLevel_3_count;
public static int NodeLevel_4_count;
public static int NodeLevel_5_count;
public static int NodeLevel_6_count;

// If Hu eats a piece, then make the square a preferred target!!!
public static int Human_last_move_target_column;
public static int Human_last_move_target_row;

// The chessboard (=skakiera in Greek)
public static String[][] Skakiera = new String[8][8]; // Δήλωση πίνακα που αντιπροσωπεύει τη σκακιέρα
public static String[][] Skakiera_Thinking_init = new String[8][8];

// Variable which determines of the program will show the inner
// thinking process of the AI. Good for educational purposes!!!
// UNCOMMENT TO SHOW INNER THINKING MECHANISM!
//bool huo_debug;

// Arrays to use in ComputerMove function
// Penalty for moving the only piece that defends a square to that square (thus leavind the defender
// alone in the square he once defended, defenceless!)
// This penalty is also used to indicate that the computer loses its Queen with the move analyzed
//v0.980: Removed. It wa not used.
//public static bool Danger_penalty;

//public static String m_PlayerColor;
//v0.980
//public static String m_ComputerLevel = "Kakos";
//public static String m_WhoPlays;
public static String m_WhichColorPlays;
public static String MovingPiece;

// Variable to store temporarily the piece that is moving
public static String ProsorinoKommati;
//public static String ProsorinoKommati_KingCheck;

// Variables to check the legality of the move
//public static boolean exit_elegxos_nomimothtas = false;
//public static int h;
//public static int p;
//public static int how_to_move_Rank;
//public static int how_to_move_Column;

public static boolean KingCheck = false;

// Coordinates of the starting square of the move
public static String m_StartingColumn;
public static int m_StartingRank;
public static String m_FinishingColumn;
public static int m_FinishingRank;

// Variable for en passant moves
//public static boolean enpassant_occured;

// Move number
public static int Move;
//v0.980
public static int number_of_moves_analysed;

// Variable to show if promotion of a pawn occured
public static boolean Promotion_Occured = false;

// Variable to show if castrling occured
public static boolean Castling_Occured = false;
public static boolean White_Castling_Occured = false;
public static boolean Black_Castling_Occured = false;
//v0.9921: The code is used again for castling!
public static boolean White_King_Moved = false;
public static boolean Black_King_Moved = false;
public static boolean Castling_Move = false;

// Variables to help find out if it is legal for the computer to perform castling
//v0.980: Removed all that code! It was not used anyway!
//public static bool White_King_Moved = false;
//public static bool Bl_King_Moved = false;
//public static bool White_Rook_a1_Moved = false;
//public static bool White_Rook_h1_Moved = false;
//public static bool Bl_Rook_a8_Moved = false;
//public static bool Bl_Rook_h8_Moved = false;
//v0.980: Removed unsused variables.
//public static bool Can_Castle_Big_White;
//public static bool Can_Castle_Big_Bl;
//public static bool Can_Castle_Small_White;
//public static bool Can_Castle_Small_Bl;

// If it possible to eat the queen of the opponent, go for it!
// v0.980: removed since it was not used
//public static bool go_for_it;

// Variables to show where the kings are in the chessboard
//public static int WhiteKingColumn;
//public static int WhiteKingRank;
//public static int BlKingColumn;
//public static int BlKingRank;

// Variables to show if king is in check
//public static boolean WhiteKingCheck;
//public static boolean BlackKingCheck;

// Variables to show if there is a possibility for mate
//public static bool WhiteMate = false;
//public static bool BlMate = false;
//public static bool Mate;

// Variable to show if a move is found for the H/Y to do
public static boolean Best_Move_Found;

// Variables to help find if a king is under check.
// (see CheckForWhiteCheck and CheckForBlackCheck functions)
//public static boolean DangerFromRight;
//public static boolean DangerFromLeft;
//public static boolean DangerFromUp;
//public static boolean DangerFromDown;
//public static boolean DangerFromUpRight;
//public static boolean DangerFromDownRight;
//public static boolean DangerFromUpLeft;
//public static boolean DangerFromDownLeft;

// Initial coordinates of the two kings
// (see CheckForWhiteCheck and CheckForBlackCheck functions)
public static int StartingWhiteKingColumn;
public static int StartingWhiteKingRank;
public static int StartingBlKingColumn;
public static int StartingBlKingRank;

// Volumn number inserted by the user
public static int m_StartingColumnNumber;
public static int m_FinishingColumnNumber;

///////////////////////////////////////////////////////////////////////////////////////////////////
// Μεταβλητές για τον έλεγχο της "ορθότητας" και της "νομιμότητας" μιας κίνησης του χρήστη
// Variables to check the correctess (ορθότητα) and the legality (νομιμότητα) of the moves
///////////////////////////////////////////////////////////////////////////////////////////////////

// Variable for the correctness of the move
public static boolean m_OrthotitaKinisis;
// Variable for the legality of the move
public static boolean m_NomimotitaKinisis;
// Has the user entered a wrong column?
//public static boolean m_WrongColumn;

// Variables for 'For' loops
public static int i;
public static int j;

// User choices
public static int ApophasiXristi = 1;
public static int choise_of_user;

//////////////////////////////////////
// Computer Thought
//////////////////////////////////////
// Chessboards used for the computer throught
public static String[][] Skakiera_Move_0 = new String[8][8]; // Δήλωση πίνακα που αντιπροσωπεύει τη σκακιέρα
public static String[][] Skakiera_Move_After = new String[8][8];
public static String[][] Skakiera_Thinking = new String[8][8];
public static String[][] Skakiera_CM_Check = new String[8][8];
// Rest of variables used for computer thought
//public static double Best_Move_Score;
public static int Current_Move_Score;
//public static int Best_Move_StartingColumnNumber;
//public static int Best_Move_FinishingColumnNumber;
//public static int Best_Move_StartingRank;
//public static int Best_Move_FinishingRank;
public static int Move_Analyzed;
public static boolean Stop_Analyzing;
public static int Thinking_Depth;
public static int m_StartingColumnNumber_HY;
public static int m_FinishingColumnNumber_HY;
public static int m_StartingRank_HY;
public static int m_FinishingRank_HY;
public static boolean First_Call;
public static String Who_Is_Analyzed;
public static String MovingPiece_HY;

// For writing the computer move
public static String HY_Starting_Column_Text;
public static String HY_Finishing_Column_Text;

// Variables which help find the best move of the Hu-opponent during the HY thought analysis
//v0.980 removed
//public static bool First_Call_Human_Thought;
//public static String MovingPiece_Human = "";
//public static int m_StartingColumnNumber_Human = 1;
//public static int m_FinishingColumnNumber_Human = 1;
//public static int m_StartingRank_Human = 1;
//public static int m_FinishingRank_Human = 1;

// Coordinates of the square Where the player can perform en passant
public static int enpassant_possible_target_rank;
public static int enpassant_possible_target_column;

//v0.980: Removed unused variables
// Is there a possible mate?
//public static bool Human_is_in_check;
//public static bool Possible_mate;

// Does the HY moves its King with the move it is analyzing?
//public static bool moving_the_king;

//v0.992
public static String prev_MovingPiece;
public static int prev_Best_Move_StartingColumnNumber;
public static int prev_Best_Move_StartingRank;
public static boolean Human_Move_Found;
public static boolean Pat_Found;
public static boolean Mate_Found;
public static int m_StartingColumnNumber_mate;
public static int m_FinishingColumnNumber_mate;
public static int m_StartingRank_mate;
public static int m_FinishingRank_mate;
            
///////////////////////////////////////////////////////////////////////////////////////////////////
// END OF VARIABLES DECLARATION
///////////////////////////////////////////////////////////////////////////////////////////////////


  public static void main(String[] args) {
   
   Thinking_Depth = 4;
   
   // Ask for the color the player wants to play with
   System.out.println("Huo Chess v0.991 by Spiros Kakos");
   System.out.println("Please choose color (w/b)");
   m_PlayerColor = reader.next();
   //m_PlayerColor = reader.next();
   
   // Initialize variables
   //v0.9921
   White_King_Moved = false;
   Black_King_Moved = false;
   White_Castling_Occured = false;
   Black_Castling_Occured = false;
                
   // Print the choice of the player
   // System.out.println("Your choice: " + m_PlayerColor);
   // Transform w and b to White and Black and print again (not needed, just to show how the if command works)
   if (m_PlayerColor.equals("w"))
      System.out.println("Your color : " + "White");
   else if (m_PlayerColor.equals("b"))
      System.out.println("Your color : " + "Black");
   else
      System.out.println("Invalid choice");
   
   if (m_PlayerColor.equals("w"))
   {
    // Human player plays
    m_WhoPlays = "human";
    // Call the function which sets up the initial position
    startingPosition();
    // Call the function which draws the position
    drawPosition();
    // Call the function which asks from the user to enter his move
    EnterMove();
   }
 
   if (m_PlayerColor.equals("b"))
   {
    // Call the function which sets up the initial position
    startingPosition();
    // Call the function to start the computer thinking
    Move_Analyzed = 0;
    Stop_Analyzing = false;
    First_Call = true;
    Best_Move_Found = false;
    Who_Is_Analyzed = "HY";
    m_WhichColorPlays = "White";
    ComputerMove(Skakiera);
   }
   
  }
  
  // Function which sets up the initial chessboard position
  public static void startingPosition() {
  
  // Note that chessboard ranks and columns numbers start from 0
  // i = Column (starting from 0)
  // j = Rank (starting from 0)
  
  for (int i = 7; i > -1; i--)
  {
    for (int j = 7; j > -1; j--)
    {
      // Clear the chessboard
      Skakiera[i][j] = "";
    }
  }
  
    // Put the pieces in the chessboard (e.g. WR for White Rook)
    Skakiera[0][0] = "WR";
    Skakiera[0][1] = "WP";
    Skakiera[1][0] = "WN";
    Skakiera[1][1] = "WP";
    Skakiera[2][0] = "WB";
    Skakiera[2][1] = "WP";
    Skakiera[3][0] = "WQ";
    Skakiera[3][1] = "WP";
    Skakiera[4][0] = "WK";
    Skakiera[4][1] = "WP";
    Skakiera[5][0] = "WB";
    Skakiera[5][1] = "WP";
    Skakiera[6][0] = "WN";
    Skakiera[6][1] = "WP";
    Skakiera[7][0] = "WR";
    Skakiera[7][1] = "WP";
    // Put the black pieces as well
    Skakiera[0][7] = "BR";
    Skakiera[0][6] = "BP";
    Skakiera[1][7] = "BN";
    Skakiera[1][6] = "BP";
    Skakiera[2][7] = "BB";
    Skakiera[2][6] = "BP";
    Skakiera[3][7] = "BQ";
    Skakiera[3][6] = "BP";
    Skakiera[4][7] = "BK";
    Skakiera[4][6] = "BP";
    Skakiera[5][7] = "BB";
    Skakiera[5][6] = "BP";
    Skakiera[6][7] = "BN";
    Skakiera[6][6] = "BP";
    Skakiera[7][7] = "BR";
    Skakiera[7][6] = "BP";
  }
  
  // Function to draw the chessboard position
  // It simply prints the pieces, nothing fancy
  public static void drawPosition() {
      
  // Transform chessboard to the drawChessBoard
  // by adding spaces in the empty squares.
  // This allows the program to draw a decent chessboard.
  for (int i = 0; i < 8; i++)
  {
    for (int j = 0; j < 8; j++)
    {
        if (!Skakiera[i][j].equals(""))
            drawChessBoard[i][j] = Skakiera[i][j];
        else if (Skakiera[i][j].equals(""))
            drawChessBoard[i][j] = "  ";
    }
  }
  // Print an empty line to separate the printed chessboard from the previous text in the screen
  System.out.println("");
  
  // Print one rank at a time
  //for (int i = 7; i > -1; i--)
  //{
  //    System.out.println(
  //    "[" + Skakiera[0][i] + "]" +
  //    "[" + Skakiera[1][i] + "]" +
  //    "[" + Skakiera[2][i] + "]" +
  //    "[" + Skakiera[3][i] + "]" +
  //    "[" + Skakiera[4][i] + "]" +
  //    "[" + Skakiera[5][i] + "]" +
  //    "[" + Skakiera[6][i] + "]" +
  //    "[" + Skakiera[7][i] + "]" 
  //    );
  //}
  
  System.out.println(
      "-------------------------");
      
    // Print one rank at a time
  for (int i = 7; i > -1; i--)
  {
      System.out.println(
      "|" + drawChessBoard[0][i] +
      "|" + drawChessBoard[1][i] +
      "|" + drawChessBoard[2][i] +
      "|" + drawChessBoard[3][i] +
      "|" + drawChessBoard[4][i] +
      "|" + drawChessBoard[5][i] +
      "|" + drawChessBoard[6][i] +
      "|" + drawChessBoard[7][i] + "|" 
      );
      
      System.out.println(
      "-------------------------");
  }
  
  
  }
  
   // Function which asks for the user to enter his move  
  public static void EnterMove() {
   System.out.println("");
   System.out.println("Enter move (e.g. c2c4) and press Enter. Enter 'q' to quit.");
   // Read the move the user inputs
   playerMove = reader.next();
   
   // Break the move entered in starting and finishing columns and ranks
   startingColumn = Character.toString( playerMove.charAt(0) );
   startingRank = Character.toString( playerMove.charAt(1) );
   finishingColumn = Character.toString( playerMove.charAt(2) );
   finishingRank = Character.toString( playerMove.charAt(3) );
  
   if(playerMove.equals("q"))
       System.exit(0);
   
   System.out.println("Move : " + startingColumn + startingRank + " -> " + finishingColumn + finishingRank);
   
  // Convert characters to numbers for the program to be able to process them
  startingRankNum = Integer.valueOf(startingRank);
  
  finishingRankNum = Integer.valueOf(finishingRank);
  
  switch (startingColumn)
  {
    case "a":
        startingColumnNum = 1; break;
    case "b":
        startingColumnNum = 2; break;
    case "c":
        startingColumnNum = 3; break;
    case "d":
        startingColumnNum = 4; break;
    case "e":
        startingColumnNum = 5; break;
    case "f":
        startingColumnNum = 6; break;
    case "g":
        startingColumnNum = 7; break;
    case "h":
        startingColumnNum = 8; break;
  }
  
  switch (finishingColumn)
  {
    case "a":
        finishingColumnNum = 1; break;
    case "b":
        finishingColumnNum = 2; break;
    case "c":
        finishingColumnNum = 3; break;
    case "d":
        finishingColumnNum = 4; break;
    case "e":
        finishingColumnNum = 5; break;
    case "f":
        finishingColumnNum = 6; break;
    case "g":
        finishingColumnNum = 7; break;
    case "h":
        finishingColumnNum = 8; break;
  }
 
  // Store the moving piece in the relative variable
  movingPiece = Skakiera[(startingColumnNum-1)][(startingRankNum-1)];
  System.out.println("Piece: " + movingPiece);
  System.out.println("Move : " + startingColumnNum + startingRankNum + " -> " + finishingColumnNum + finishingRankNum);
  //movingPiece = Skakiera[(startingRankNum-1)][(startingColumnNum-1)];
  
  // Just a test to show how if statement is working
  //   if ((startingRankNum == finishingRankNum) || (startingColumnNum == finishingColumnNum))
  //      System.out.println("Test 1!");
  
  // Call the function which checks for move legality.
  // There result of the check will be returned to the variable moveLegality
  // The parameters passed over to the function are the starting and finishing ranks and columns plus the moving piece
  m_WhoPlays = "Human";
  m_WrongColumn = false;
  //V0.9921
  Castling_Move = false;
  
  //v0.9921: Code for castling
  if (MovingPiece.equals("White King"))
      White_King_Moved = true;
  else if (MovingPiece.equals("Black King"))
      Black_King_Moved = true;

  // v0.992: Pawn promotion is checked once centrally through pawn promotion function PawnPromotion()!!
  //         However this is needed here so as to calculate correctly the value of the human piece!
  //         So since I do this here, the PawnPromotion() call is not needed... :P
  // v0.990
  // Promotion
  if ((MovingPiece.equals("White Pawn")) && (m_FinishingRank == 8))
      MovingPiece = "White Queen";
  if ((MovingPiece.equals("Black Pawn")) && (m_FinishingRank == 1))
      MovingPiece = "Black Queen";

  // Check if castling occured (so as to move the rook next to the moving king)
  // v0.9921: Simplified code
  if (m_PlayerColor.equals("w"))
  {
      //MessageBox.Show("Checkpoint 1.5");
      if ((MovingPiece.equals("White King")) &&
          (m_StartingColumnNumber == 5) &&
          (m_StartingRank == 1) &&
          (m_FinishingColumnNumber == 7) &&
          (m_FinishingRank == 1))
      {
          Skakiera[(5)][(0)] = "White Rook";
          Skakiera[(7)][(0)] = "";
          White_Castling_Occured = true;
          //MessageBox.Show( "Ο λευκός κάνει μικρό ροκε." );
      }
      else if ((MovingPiece.equals("White King")) &&
              (m_StartingColumnNumber == 5) &&
              (m_StartingRank == 1) &&
              (m_FinishingColumnNumber == 3) &&
              (m_FinishingRank == 1))
      {
          Skakiera[(3)][(0)] = "White Rook";
          Skakiera[(0)][(0)] = "";
          White_Castling_Occured = true;
          //MessageBox.Show( "Ο λευκός κάνει μεγάλο ροκε." );
      }
  }
  else if (m_PlayerColor.equals("b"))
  {
      if ((MovingPiece.equals("Black King")) &&
              (m_StartingColumnNumber == 5) &&
              (m_StartingRank == 8) &&
              (m_FinishingColumnNumber == 7) &&
              (m_FinishingRank == 8))
      {
          Skakiera[(5)][(7)] = "Black Rook";
          Skakiera[(7)][(7)] = "";
          Black_Castling_Occured = true;
          //MessageBox.Show( "Ο μαύρος κάνει μικρό ροκε." );
      }
      else if ((MovingPiece.equals("Black King")) &&
              (m_StartingColumnNumber == 5) &&
              (m_StartingRank == 8) &&
              (m_FinishingColumnNumber == 3) &&
              (m_FinishingRank == 8))
      {
          Skakiera[(3)][(7)] = "Black Rook";
          Skakiera[(0)][(7)] = "";
          Black_Castling_Occured = true;
          //MessageBox.Show( "Ο μαύρος κάνει μεγάλο ροκε." );
      }
  }
  
  // Call the function which checks the move's legality
  // startingRankNum = startingRankNum + 1;
  // startingColumnNum = startingColumnNum + 1;
  // finishingRankNum = finishingRankNum + 1;
  // finishingColumnNum = finishingColumnNum + 1;
  moveValidity = ElegxosOrthotitas(Skakiera, 0, startingRankNum, startingColumnNum, finishingRankNum, finishingColumnNum, movingPiece);
  moveLegality = ElegxosNomimotitas(Skakiera, 0, startingRankNum, startingColumnNum, finishingRankNum, finishingColumnNum, movingPiece);
  
  //v0.9921: If castling, then Orthotita is also OK!
  if (Castling_Move == true)
  {
      moveValidity = true;
      moveLegality = true;
  }
                
  if ((moveValidity == true) && (moveLegality == true))
  {
      System.out.println("Valid move");
      // Do the move
      Skakiera[(finishingColumnNum-1)][(finishingRankNum-1)] = movingPiece;
      Skakiera[(startingColumnNum-1)][(startingRankNum-1)] = "";
      // Draw the chessboard
      drawPosition();
      
      // Call the function to start the computer thinking
    Move_Analyzed = 0;
    Stop_Analyzing = false;
    First_Call = true;
    Best_Move_Found = false;
    Who_Is_Analyzed = "HY";
    m_WhichColorPlays = "Black";
    ComputerMove(Skakiera);
  }
  else
  {
      System.out.println("Wrong move!");
      System.out.println("Castling_Move = " + Castling_Move);
      System.out.println("Validity = " + moveValidity);
      System.out.println("Legality = " + moveLegality);
  }
}
  
public static void CheckMove(String[][] CMSkakiera, int m_StartingRankCM, int m_StartingColumnNumberCM, int m_FinishingRankCM, int m_FinishingColumnNumberCM, String MovingPieceCM)
{
        ///#region WriteLog
        //huo_sw1.WriteLine("");
        //huo_sw1.WriteLine("ChMo -- Entered CheckMove");
        //huo_sw1.WriteLine(string.Concat("ChMo -- Depth analyzed: ", Move_Analyzed.ToString()));
        //huo_sw1.WriteLine(string.Concat("ChMo -- Number of moves analyzed: ", number_of_moves_analysed.ToString()));
        //huo_sw1.WriteLine(string.Concat("ChMo -- Move analyzed: ", m_StartingColumnNumber_HY.ToString(), m_StartingRank_HY.ToString(), " -> ", m_FinishingColumnNumber_HY.ToString(), m_FinishingRank_HY.ToString()));
        //huo_sw1.WriteLine(string.Concat("ChMo -- Number of Nodes 0: ", NodeLevel_0_count.ToString()));
        //huo_sw1.WriteLine(string.Concat("ChMo -- Number of Nodes 1: ", NodeLevel_1_count.ToString()));
        //huo_sw1.WriteLine(string.Concat("ChMo -- Number of Nodes 2: ", NodeLevel_2_count.ToString()));
        //huo_sw1.WriteLine(string.Concat("ChMo -- Number of Nodes 3: ", NodeLevel_3_count.ToString()));
        //huo_sw1.WriteLine(string.Concat("ChMo -- Number of Nodes 4: ", NodeLevel_4_count.ToString()));
        //huo_sw1.WriteLine(string.Concat("ChMo -- Number of Nodes 5: ", NodeLevel_5_count.ToString()));
        //huo_sw1.WriteLine(string.Concat("ChMo -- Number of Nodes 6: ", NodeLevel_6_count.ToString()));
        //huo_sw1.WriteLine("");
        ///#endregion WriteLog

        String ProsorinoKommatiCM;

        for (int iii = 0; iii <= 7; iii++)
        {
                for (int jjj = 0; jjj <= 7; jjj++)
                {
                        Skakiera_CM_Check[iii][jjj] = CMSkakiera[(iii)][(jjj)];
                }
        }

        number_of_moves_analysed++;

        m_WhoPlays = "Human";
        m_WrongColumn = false;

        // Check correctness of move
        m_OrthotitaKinisis = ElegxosOrthotitas(CMSkakiera, 0, m_StartingRankCM, m_StartingColumnNumberCM, m_FinishingRankCM, m_FinishingColumnNumberCM, MovingPieceCM);
        // if move is correct, then check the legality also
        if (m_OrthotitaKinisis == true)
        {
                m_NomimotitaKinisis = ElegxosNomimotitas(CMSkakiera, 0, m_StartingRankCM, m_StartingColumnNumberCM, m_FinishingRankCM, m_FinishingColumnNumberCM, MovingPieceCM);
        }

        // Restore the normal value of the m_WhoPlays
        m_WhoPlays = "HY";

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
        ///#region CheckCheck

        // Temporarily move the piece to see if the king will continue to be under check
        Skakiera_CM_Check[(m_StartingColumnNumberCM - 1)][(m_StartingRankCM - 1)] = "";
        ProsorinoKommatiCM = Skakiera_CM_Check[(m_FinishingColumnNumberCM - 1)][(m_FinishingRankCM - 1)];
        // Προσωρινή αποθήκευση του κομματιού που βρίσκεται στο τετράγωνο προορισμού
        // (βλ. μετά για τη χρησιμότητα του, εκεί που γίνεται έλεγχος για το αν συνεχίζει να υφίσταται σαχ).
        Skakiera_CM_Check[(m_FinishingColumnNumberCM - 1)][(m_FinishingRankCM - 1)] = MovingPieceCM;

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
        ///#region Remove
        //v0.990: Need to check again the dangerous squares? The computer might attempt to move
        //        his piece to a square where the moving piece was the only defender!
        //v0.990 change: The dangerous squares must be checked AGAIN after the move!
        //The moving piece might be moving into a dangerous square!
        //v0.990 change: Added this section here!
        /*
        #region DangerousSquares

        Danger_for_piece = false;

        for (int o1 = 0; o1 <= 7; o1++)
        {
            for (int p1 = 0; p1 <= 7; p1++)
            {
                //v0.980: Change small Strings to Int
                Skakiera_Dangerous_Squares_2[(o1), (p1)] = 0;
            }
        }

        // Find attackers-defenders
        FindAttackers(CMSkakiera);
        FindDefenders(CMSkakiera);

        // Determine dangerous squares
        for (int o1 = 0; o1 <= 7; o1++)
        {
            for (int p1 = 0; p1 <= 7; p1++)
            {
                //v0.990 debug
                //MessageBox.Show(String.Concat("Number of attackers for ", (o1 + 1).ToString(), (p1 + 1).ToString(), " : ", Number_of_attackers[o1, p1].ToString()));
                //MessageBox.Show(String.Concat("Number of defenders for ", (o1 + 1).ToString(), (p1 + 1).ToString(), " : ", Number_of_defenders[o1, p1].ToString()));

                //v0.990 change: Changed ">" to ">="
                if (Number_of_attackers[o1, p1] >= Number_of_defenders[o1, p1])
                    //if (Number_of_attackers[o1, p1] > Number_of_defenders[o1, p1])
                    //v0.980: Change small Strings to Int
                    Skakiera_Dangerous_Squares_2[(o1), (p1)] = 1;
            }
        }
        #endregion DangerousSquares

        if(Skakiera_Dangerous_Squares_2[(m_FinishingColumnNumberCM - 1), (m_FinishingRankCM - 1)] == 1)
            m_NomimotitaKinisis = false;
        */
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
        ///#endregion Remove

        //////////////////////////////////////////////////////////////////////////
        // is the king still under check?
        //////////////////////////////////////////////////////////////////////////

        //v0.990
        WhiteKingCheck = CheckForWhiteCheck(Skakiera_CM_Check);
        //WhiteKingCheck = CheckForWhiteCheck(CMSkakiera);

        if ((m_WhichColorPlays.equals("White")) && (WhiteKingCheck == true))
        {
                m_NomimotitaKinisis = false;
        }

        ///////////////////////////////////////////////////////////////////////////
        // is the black king under check?
        ///////////////////////////////////////////////////////////////////////////

        //v0.990
        //BlackKingCheck = CheckForBlackCheck(CMSkakiera);
        BlackKingCheck = CheckForBlackCheck(Skakiera_CM_Check);

        if ((m_WhichColorPlays.equals("Black")) && (BlackKingCheck == true))
        {
                m_NomimotitaKinisis = false;
        }

        // Restore pieces to their initial positions
        // CMSkakiera[(m_StartingColumnNumberCM - 1), (m_StartingRankCM - 1)] = MovingPieceCM;
        // CMSkakiera[(m_FinishingColumnNumberCM - 1), (m_FinishingRankCM - 1)] = ProsorinoKommatiCM;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
        ///#endregion CheckCheck

        //v0.990: Removed! This is already done in ComputerMove!
        /*
        if (((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true)) && (Move_Analyzed == 0))
        {
            // Store the move to ***_HY variables (because after continuous calls of ComputerMove the initial move under analysis will be lost...)

            MovingPiece_HY = MovingPiece;
            m_StartingColumnNumber_HY = m_StartingColumnNumber;
            m_FinishingColumnNumber_HY = m_FinishingColumnNumber;
            m_StartingRank_HY = m_StartingRank;
            m_FinishingRank_HY = m_FinishingRank;

            // Store the initial move coordinates (at the node 0 level)
            NodesAnalysis0[NodeLevel_0_count, 2] = m_StartingColumnNumber_HY;
            NodesAnalysis0[NodeLevel_0_count, 3] = m_FinishingColumnNumber_HY;
            NodesAnalysis0[NodeLevel_0_count, 4] = m_StartingRank_HY;
            NodesAnalysis0[NodeLevel_0_count, 5] = m_FinishingRank_HY;

            // Check is HY eats the opponents queen (so it is preferable to do so...)
            // Not operational yet...
            //if ((ProsorinoKommati.equals("WQ")) || (ProsorinoKommati.equals("BQ")))
            //    go_for_it = true;
            // v0.970: Danger penalty now checked directly in ComputerMove
        }
        */

}

  
public static void ComputerMove(String[][] Skakiera_Thinking_init)
{
        // v0.990 change: The best score for every move will be stored at each level. Only if the new move analyzed
        // has a better score than the best score, will it be analyzed (target: trim the analysis tree)
        int bestScoreLevel0 = 0;
        //V0.990: Initialized the values
        int iii = 0;
        int jjj = 0;
        Temp_Score_Move_0 = 0;
        Temp_Score_Move_1_human = 0;
        Temp_Score_Move_2 = 0;
        Human_last_move_target_column = 0;
        Human_last_move_target_row = 0;
        MovingPiece = "";
        ProsorinoKommati = "";
        exit_elegxos_nomimothtas = false;
        First_Call = true;
        h = 0;
        p = 0;
        WhiteKingColumn = 0;
        WhiteKingRank = 0;
        BlKingColumn = 0;
        BlKingRank = 0;
        DangerFromUp = false;
        m_OrthotitaKinisis = false;
        m_NomimotitaKinisis = false;
        i = 0;
        j = 0;
        Current_Move_Score = 0;
        Best_Move_FinishingColumnNumber = 0;
        Best_Move_FinishingRank = 0;
        Best_Move_StartingColumnNumber = 0;
        Best_Move_StartingRank = 0;
        Stop_Analyzing = true;
        m_StartingColumnNumber_HY = 0;
        m_StartingRank_HY = 0;
        m_FinishingColumnNumber_HY = 0;
        m_FinishingRank_HY = 0;
        enpassant_possible_target_column = 0;
        //First_Caenpassant_possible_target_rankll = 0;
        //v0.990: Removed the "0" variables.
        //String MovingPiece;
        //String ProsorinoKommati0;
        //int m_StartingColumnNumber;
        //int m_FinishingColumnNumber;
        //int m_StartingRank;
        //int m_FinishingRank;

        //v0.990
        String[][] Skakiera_Move_After_0 = new String[8][8];

        // If there is a possibility to eat back what was eaten, then go for it!
        possibility_to_eat_back = false;
        possibility_to_eat = false;

        ///#region InitializeNodes
        // START [MiniMax algorithm - skakos]
        NodeLevel_0_count = 0;
        NodeLevel_1_count = 0;
        NodeLevel_2_count = 0;
        //v0.980: Removed unwanted nodes (+total nodes)
        NodeLevel_3_count = 0;
        NodeLevel_4_count = 0;
        Nodes_Total_count = 0;

        //v0.990 Added initialization of variables
        ValueOfHumanMovingPiece = 0;
        ValueOfMovingPiece = 0;

        //0.970
        for (int dimension1 = 0; dimension1 < 1000000; dimension1++)
        {
                for (int dimension2 = 0; dimension2 < 6; dimension2++)
                {
                        NodesAnalysis0[dimension1][dimension2] = 0;
                }
        }

        for (int dimension1 = 0; dimension1 < 1000000; dimension1++)
        {
                for (int dimension2 = 0; dimension2 < 2; dimension2++)
                {
                        NodesAnalysis1[dimension1][dimension2] = 0;
                        NodesAnalysis2[dimension1][dimension2] = 0;
                        //NodesAnalysis3[dimension1, dimension2] = 0;
                }
        }

        for (int dimension1 = 0; dimension1 < 10000000; dimension1++)
        {
                for (int dimension2 = 0; dimension2 < 2; dimension2++)
                {
                        NodesAnalysis3[dimension1][dimension2] = 0;
                        NodesAnalysis4[dimension1][dimension2] = 0;
                        //NodesAnalysis3[dimension1, dimension2] = 0;
                }
        }
                
        // Store the initial position in the chessboard
        for (iii = 0; iii <= 7; iii++)
        {
                for (jjj = 0; jjj <= 7; jjj++)
                {
                        Skakiera_Thinking[iii][jjj] = Skakiera_Thinking_init[(iii)][(jjj)];
                        Skakiera_Move_0[(iii)][(jjj)] = Skakiera_Thinking_init[(iii)][(jjj)];
                }
        }

        // CHECK IF POSITION IS IN THE OPENING BOOK - Removed in v0.980

        // CHECK FOR DANGEROUS SQUARES
        // Also find number and value of attackers and defenders for each square of the chessboard: will be used below to determine if the move is stupid
        Danger_for_piece = false;

        for (int o1 = 0; o1 <= 7; o1++)
        {
                for (int p1 = 0; p1 <= 7; p1++)
                {
                        //v0.980: Change small Strings to Int
                        Skakiera_Dangerous_Squares[(o1)][(p1)] = 0;
                        //v0.990 test. Added initialization. By adding it it makes the computer not wanting to eat the bishop.
                        Value_of_defenders[(o1)][(p1)] = 0;
                        Value_of_attackers[(o1)][(p1)] = 0;
                        //v0.990: Added also these initializations! Let's see what happens now...
                        //        I had forgot those! Could this be the reason the HY did not
                        //        want to eat the bishop?
                        Number_of_defenders[(o1)][(p1)] = 0;
                        Number_of_attackers[(o1)][(p1)] = 0;
                }
        }

        // Find attackers-defenders
        FindAttackers(Skakiera_Thinking);
        FindDefenders(Skakiera_Thinking);

        // Determine dangerous squares
        for (int o1 = 0; o1 <= 7; o1++)
        {
                for (int p1 = 0; p1 <= 7; p1++)
                {
                        //The case where the only defender is the moving piece can only be captured 
                        //in the CheckMove function!
                        if (Number_of_attackers[o1][p1] > Number_of_defenders[o1][p1])
                        {
                                //v0.980: Change small Strings to Int
                                Skakiera_Dangerous_Squares[(o1)][(p1)] = 1;
                        }
                }
        }

        ///#endregion DangerousSquares

        // v0.990
        // Check if HY is currently under check
        ThereIsCheck = false;

        if (m_PlayerColor.equals("w"))
        {
                ThereIsCheck = CheckForBlackCheck(Skakiera_Thinking);
        }
        else if (m_PlayerColor.equals("b"))
        {
                ThereIsCheck = CheckForBlackCheck(Skakiera_Thinking);
        }

        //---------------------------------------
        // CHECK ALL POSSIBLE MOVES!
        //---------------------------------------

        for (iii = 0; iii <= 7; iii++)
        {
                for (jjj = 0; jjj <= 7; jjj++)
                {
                        //v0.980: Reduce all texts ("WK" for "Wh King", "WN" for "Wh Knight" and so on...)
                        if (((Who_Is_Analyzed.equals("HY")) && ((((Skakiera_Thinking[(iii)][(jjj)].equals("WK")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WQ")) || (Skakiera_Thinking[(iii)][(jjj)].equals("White Rook")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WN")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WB")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WP"))) && (m_PlayerColor.equals("b"))) || (((Skakiera_Thinking[(iii)][(jjj)].equals("BK")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BQ")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BR")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BN")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BB")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BP"))) && (m_PlayerColor.equals("w"))))) || ((Who_Is_Analyzed.equals("Hu")) && ((((Skakiera_Thinking[(iii)][(jjj)].equals("WK")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WQ")) || (Skakiera_Thinking[(iii)][(jjj)].equals("White Rook")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WN")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WB")) || (Skakiera_Thinking[(iii)][(jjj)].equals("WP"))) && (m_PlayerColor.equals("w"))) || (((Skakiera_Thinking[(iii)][(jjj)].equals("BK")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BQ")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BR")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BN")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BB")) || (Skakiera_Thinking[(iii)][(jjj)].equals("BP"))) && (m_PlayerColor.equals("b"))))))
                        {

                                for (int w = 0; w <= 7; w++)
                                {
                                        for (int r = 0; r <= 7; r++)
                                        {
                                                //v0.980: Removed. It was not used.
                                                //Danger_penalty = false;
                                                MovingPiece = Skakiera_Thinking[(iii)][(jjj)];
                                                m_StartingColumnNumber = iii + 1;
                                                m_FinishingColumnNumber = w + 1;
                                                m_StartingRank = jjj + 1;
                                                m_FinishingRank = r + 1;

                                                // Store temporary move data in local variables, so as to use them in the Undo of the move
                                                // at the end of this function (the MovingPiece, m_StartingColumnNumber, etc variables are
                                                // changed by next functions as well, so using them leads to problems)
                                                // ProsorinoKommati = Skakiera_Thinking[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)];

                                                // Check for stupid moves in the start of the game
                                                ThisIsStupidMove = "N";

                                                if (Move < 5)
                                                {
                                                        if ((MovingPiece.equals("WQ")) || (MovingPiece.equals("BQ")) || (MovingPiece.equals("White Rook")) || (MovingPiece.equals("BR")))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if (((MovingPiece.equals("WN")) || (MovingPiece.equals("BN"))) && (m_FinishingColumnNumber == 1))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if (((MovingPiece.equals("WN")) || (MovingPiece.equals("BN"))) && (m_FinishingColumnNumber == 8))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("WN")) && (m_FinishingRank == 2) && (m_FinishingColumnNumber == 4) && (Skakiera_Thinking[(2)][(0)].equals("WB")))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("WN")) && (m_FinishingRank == 2) && (m_FinishingColumnNumber == 5) && (Skakiera_Thinking[(5)][(0)].equals("WB")))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("BN")) && (m_FinishingRank == 7) && (m_FinishingColumnNumber == 4) && (Skakiera_Thinking[(2)][(7)].equals("BB")))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("BN")) && (m_FinishingRank == 7) && (m_FinishingColumnNumber == 5) && (Skakiera_Thinking[(5)][(7)].equals("BB")))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("WP")) && ((m_StartingColumnNumber == 1) || (m_StartingColumnNumber == 2)))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("WP")) && ((m_StartingColumnNumber == 7) || (m_StartingColumnNumber == 8)))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("BP")) && ((m_StartingColumnNumber == 1) || (m_StartingColumnNumber == 2)))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("BP")) && ((m_StartingColumnNumber == 7) || (m_StartingColumnNumber == 8)))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if ((MovingPiece.equals("WK")) || (MovingPiece.equals("BK")))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                        else if (((MovingPiece.equals("WB")) || (MovingPiece.equals("BB"))) && ((m_FinishingRank == 3) || (m_FinishingRank == 5) || (m_FinishingRank == 6)))
                                                        {
                                                                ThisIsStupidMove = "Y";
                                                        }
                                                }

                                                // v0.970
                                                // Store the value of the moving piece
                                                if ((MovingPiece.equals("WR")) || (MovingPiece.equals("BR")))
                                                {
                                                        ValueOfMovingPiece = 5;
                                                }
                                                if ((MovingPiece.equals("WN")) || (MovingPiece.equals("BN")))
                                                {
                                                        ValueOfMovingPiece = 3;
                                                }
                                                if ((MovingPiece.equals("WB")) || (MovingPiece.equals("BB")))
                                                {
                                                        ValueOfMovingPiece = 3;
                                                }
                                                if ((MovingPiece.equals("WQ")) || (MovingPiece.equals("BQ")))
                                                {
                                                        ValueOfMovingPiece = 9;
                                                }
                                                if ((MovingPiece.equals("WK")) || (MovingPiece.equals("BK")))
                                                {
                                                        ValueOfMovingPiece = 119;
                                                }
                                                if ((MovingPiece.equals("WP")) || (MovingPiece.equals("BP")))
                                                {
                                                        ValueOfMovingPiece = 1;
                                                }

                                                // If a pieve of lower value attacks the square where the computer moves, then... stupid move!
                                                if ((Number_of_attackers[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)] >= 1) && (Value_of_attackers[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)] < ValueOfMovingPiece))
                                                {
                                                        ThisIsStupidMove = "Y";
                                                }

                                                //if ((ThisIsStupidMove.equals("N")) && (Skakiera_Dangerous_Squares[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)] == 0))
                                                if ( 1 == 1 )
                                                {
                                                //if ((Skakiera_Dangerous_Squares[(m_FinishingColumnNumber - 1), (m_FinishingRank - 1)] == 0))
                                                        // THE HEART OF THE THINKING MECHANISM: Here the computer checks the moves

                                                        // Validity and legality of the move will be checked in CheckMove
                                                        // (plus some additional checks for possible mate etc)
                                                        CheckMove(Skakiera_Thinking, m_StartingRank, m_StartingColumnNumber, m_FinishingRank, m_FinishingColumnNumber, MovingPiece);
                                                        //CheckMove(Skakiera_Thinking);

                                                        //v0.980: Removed
                                                        //number_of_moves_analysed++;

                                                        if (((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true)) && (Move_Analyzed == 0))
                                                        {
                                                                // Store the move to ***_HY variables (because after continuous calls of ComputerMove the initial move under analysis will be lost...)

                                                                MovingPiece_HY = MovingPiece;
                                                                m_StartingColumnNumber_HY = m_StartingColumnNumber;
                                                                m_FinishingColumnNumber_HY = m_FinishingColumnNumber;
                                                                m_StartingRank_HY = m_StartingRank;
                                                                m_FinishingRank_HY = m_FinishingRank;

                                                                // Store the initial move coordinates (at the node 0 level)
                                                                NodesAnalysis0[NodeLevel_0_count][2] = m_StartingColumnNumber_HY;
                                                                NodesAnalysis0[NodeLevel_0_count][3] = m_FinishingColumnNumber_HY;
                                                                NodesAnalysis0[NodeLevel_0_count][4] = m_StartingRank_HY;
                                                                NodesAnalysis0[NodeLevel_0_count][5] = m_FinishingRank_HY;

                                                                // Now at least one legal move is found (used to determine if there is checkmate)
                                                                Best_Move_Found = true;
                                                        }


                                                        // If everything is OK, then do the move and measure it's score
                                                        if ((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true))
                                                        {
                                                                // Do the move
                                                                ProsorinoKommati = Skakiera_Thinking[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)];
                                                                Skakiera_Thinking[(m_StartingColumnNumber - 1)][(m_StartingRank - 1)] = "";
                                                                Skakiera_Thinking[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)] = MovingPiece;

                                                                // v0.990
                                                                if ((MovingPiece.equals("WR")) || (MovingPiece.equals("BR")))
                                                                {
                                                                        ValueOfKommati = 5;
                                                                }
                                                                if ((MovingPiece.equals("WN")) || (MovingPiece.equals("BN")))
                                                                {
                                                                        ValueOfKommati = 3;
                                                                }
                                                                if ((MovingPiece.equals("WB")) || (MovingPiece.equals("BB")))
                                                                {
                                                                        ValueOfKommati = 3;
                                                                }
                                                                if ((MovingPiece.equals("WQ")) || (MovingPiece.equals("BQ")))
                                                                {
                                                                        ValueOfKommati = 9;
                                                                }
                                                                if ((MovingPiece.equals("WK")) || (MovingPiece.equals("BK")))
                                                                {
                                                                        ValueOfKommati = 119;
                                                                }
                                                                if ((MovingPiece.equals("WP")) || (MovingPiece.equals("BP")))
                                                                {
                                                                        ValueOfKommati = 1;
                                                                }

                                                                if ((ProsorinoKommati.equals("WR")) || (ProsorinoKommati.equals("BR")))
                                                                {
                                                                        ValueOfTargetPiece = 5;
                                                                }
                                                                if ((ProsorinoKommati.equals("WN")) || (ProsorinoKommati.equals("BN")))
                                                                {
                                                                        ValueOfTargetPiece = 3;
                                                                }
                                                                if ((ProsorinoKommati.equals("WB")) || (ProsorinoKommati.equals("BB")))
                                                                {
                                                                        ValueOfTargetPiece = 3;
                                                                }
                                                                if ((ProsorinoKommati.equals("WQ")) || (ProsorinoKommati.equals("BQ")))
                                                                {
                                                                        ValueOfTargetPiece = 9;
                                                                }
                                                                if ((ProsorinoKommati.equals("WK")) || (ProsorinoKommati.equals("BK")))
                                                                {
                                                                        ValueOfTargetPiece = 119;
                                                                }
                                                                if ((ProsorinoKommati.equals("WP")) || (ProsorinoKommati.equals("BP")))
                                                                {
                                                                        ValueOfTargetPiece = 1;
                                                                }

                                                                // Check the score after the computer move
                                                                Temp_Score_Move_0 = CountScore(Skakiera_Thinking);
                                                                
                                                                // v0.992: Score and parent for each move analyzed are stored on the spot and not at the end of the thinking depth
                                                                // since some branches of the thinking tree might be trimmed, thus not available at the end of the thinking depth for
                                                                // their score and parent to be stored!
                                                                // Store scores
                                                                NodesAnalysis0[NodeLevel_0_count][0] = Temp_Score_Move_0;
                                                                // Store parents
                                                                // For initial level of thought, there is no parent (i.e. value = 0)
                                                                NodesAnalysis0[NodeLevel_0_count][1] = 0;

                                                                // v0.990 change
                                                                // Store the best move score at this level
                                                                if ((m_PlayerColor.equals("b")) && (Temp_Score_Move_0 > bestScoreLevel0))
                                                                {
                                                                        bestScoreLevel0 = Temp_Score_Move_0;
                                                                }
                                                                else if ((m_PlayerColor.equals("w")) && (Temp_Score_Move_0 < bestScoreLevel0))
                                                                {
                                                                        bestScoreLevel0 = Temp_Score_Move_0;
                                                                }

                                                                ///#region Eat
                                                                if (ValueOfKommati < ValueOfTargetPiece)
                                                                {
                                                                        Best_Move_StartingColumnNumber = m_StartingColumnNumber;
                                                                        Best_Move_StartingRank = m_StartingRank;
                                                                        Best_Move_FinishingColumnNumber = m_FinishingColumnNumber;
                                                                        Best_Move_FinishingRank = m_FinishingRank;

                                                                        possibility_to_eat = true;
                                                                }

                                                                ///#region EatBack
                                                                // v0.970: Check if you can eat back the piece of the Hu which moved!
                                                                if ((m_FinishingColumnNumber == Human_last_move_target_column) && (m_FinishingRank == Human_last_move_target_row) && (ValueOfMovingPiece <= ValueOfHumanMovingPiece))
                                                                {
                                                                        Best_Move_StartingColumnNumber = m_StartingColumnNumber;
                                                                        Best_Move_StartingRank = m_StartingRank;
                                                                        Best_Move_FinishingColumnNumber = m_FinishingColumnNumber;
                                                                        Best_Move_FinishingRank = m_FinishingRank;

                                                                        possibility_to_eat_back = true;
                                                                }

                                                                // v0.970: If you can eat back the piece of the Hu, then go for it and don't analyze!
                                                                // v0.990: Added the possibility_to_eat
                                                                if ((Move_Analyzed < Thinking_Depth) && (possibility_to_eat_back == false))
                                                                {
                                                                        Move_Analyzed = Move_Analyzed + 1;

                                                                        //v0.990
                                                                        String[][] Skakiera_Move_After_0_new = new String[8][8];

                                                                        for (i = 0; i <= 7; i++)
                                                                        {
                                                                                for (j = 0; j <= 7; j++)
                                                                                {
                                                                                        Skakiera_Move_After_0[(i)][(j)] = Skakiera_Thinking[(i)][(j)];
                                                                                        Skakiera_Move_After_0_new[(i)][(j)] = Skakiera_Thinking[(i)][(j)];
                                                                                }
                                                                        }

                                                                        //v0.980: removed
                                                                        Who_Is_Analyzed = "Human";
                                                                        //First_Call_Human_Thought = true;

                                                                        // v0.992: Switch which colour plays.
                                                                        // This is used for the check for check in ElegxosNomimotitas
                                                                        if (m_PlayerColor.equals("b"))
                                                                            m_WhichColorPlays = "Black";
                                                                        else if (m_PlayerColor.equals("w"))
                                                                            m_WhichColorPlays = "White";
                                                    
                                                                        // Check Hu move (to find the best possible answer of the Hu
                                                                        // to the move currently analyzed by the HY Thought process)
                                                                        Analyze_Move_1_HumanMove(Skakiera_Move_After_0_new);
                                                                        
                                                                        // v0.992: Switch BACK which colour plays.
                                                                        // This is used for the check for check in ElegxosNomimotitas
                                                                        if (m_PlayerColor.equals("b"))
                                                                            m_WhichColorPlays = "White";
                                                                        else if (m_PlayerColor.equals("w"))
                                                                            m_WhichColorPlays = "Black";
                                                                }

                                                                // Undo the move
                                                                Skakiera_Thinking[(m_StartingColumnNumber - 1)][(m_StartingRank - 1)] = MovingPiece;
                                                                Skakiera_Thinking[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)] = ProsorinoKommati;

                                                                //v0.992
                                                                // If Pat (= Stalemate) found then reset the score!
                                                                if (Pat_Found == true)
                                                                {
                                                                    NodesAnalysis0[(NodeLevel_0_count)][(0)] = 0;
                                                                    Pat_Found = false;
                                                                }
                                                
                                                                //v0.991: This should be done here
                                                                NodeLevel_0_count++;
                                                        }

                                                }

                                        }
                                }

                        }


                }
        }

        // v0.990
        //if (((WhiteKingCheck == true) || (BlackKingCheck == true)) && (Best_Move_Found == false))
        if ((ThereIsCheck == true) && (Best_Move_Found == false))
        {
                //v0.990
                System.out.println("Checkmate!");
                //Console.WriteLine("Checkmate!");
        }
        ///#endregion CheckIfMate

        // DO THE BEST MOVE FOUND
        // Analyze only if possibility to eat back is not true!!!
        // MessageBox.Show("Entered Best Move found area!");

        //v0.990 test: Add a log of the nodes
        //v0.990: Added the possibility_to_eat
        //v0.991: Removed possibility to eat! Why not think everything?
        if ((possibility_to_eat_back == false))
        {
                // MessageBox.Show("Entered checkpoint 1");
                // [MiniMax algorithm - skakos]
                // Find node 1 move with the best score via the MiniMax algorithm.
                // v0.990 Move 4 changes
                int counter0, counter1, counter2, counter3, counter4; // v0.980: Remove unsued counter3,4. counter3, counter4, counter5, counter6, counter7, counter8, counter9, counter10;

                // ------------------------------------------------------
                // NodesAnalysis
                // ------------------------------------------------------
                // Nodes structure...
                // [ccc, xxx, 0]: Score of node No. ccc at level xxx
                // [ccc, xxx, 1]: Parent of node No. ccc at level xxx-1

                // Move 4 level (Computer)

                int parentNodeAnalyzed = -999;

                // v0.991: Added this so as to make this activated only when Thinking_Depth = 4.
                if (Thinking_Depth == 4)
                {
                    // v0.991: Start from 0! Ends at "< NodeLevel_4_count" since the node count is increased before the next node is analyzed...
                    // (see Checkpoint increaseNodeCount for example)
                    for (counter4 = 0; counter4 < NodeLevel_4_count; counter4++)
                    {
                        if (NodesAnalysis4[counter4][1] != parentNodeAnalyzed)
                        {
                            // parentNodeAnalyzedchanged = true;
                            // Update the parent node analyzed with the new one
                            parentNodeAnalyzed = NodesAnalysis4[counter4][1];
                            // For the first parent node, store the score in the parent node. After that, compare to see if you need to replace!
                            NodesAnalysis3[NodesAnalysis4[counter4][1]][0] = NodesAnalysis4[counter4][0];
                            // v0.992: Best variant move text propagation
                            //NodesAnalysis3_MoveText[Int32.Parse(NodesAnalysis4[counter4, 1].ToString())] = String.Concat(NodesAnalysis3_MoveText[Int32.Parse(NodesAnalysis4[counter4, 1].ToString())].ToString(), " , ", NodesAnalysis4_MoveText[counter4].ToString());
                            //bestNode4 = counter4;
                            //bestNodes4[parentNodeAnalyzed] = counter4;
                        }

                        //v0.990: Do we need to check for "<=" here? Os should we start checking for ">="?
                        //v0.991: Start analysis with < instead of > ?
                        //v0.992: Fixed to work as the code in the node 2. Added the Best variant MoveText propagation.
                        if (m_PlayerColor.equals("w"))
                        {
                            if (NodesAnalysis4[counter4][0] <= NodesAnalysis3[NodesAnalysis4[counter4][1]][0])
                            {
                                NodesAnalysis3[NodesAnalysis4[counter4][1]][0] = NodesAnalysis4[counter4][0];
                                // v0.992: Best variant move text propagation
                                //NodesAnalysis3_MoveText[Int32.Parse(NodesAnalysis4[counter4, 1].ToString())] = String.Concat(NodesAnalysis3_MoveText[Int32.Parse(NodesAnalysis4[counter4, 1].ToString())].ToString(), " , ", NodesAnalysis4_MoveText[counter4].ToString());
                                //bestNode4 = counter4;
                                //bestNodes4[parentNodeAnalyzed] = counter4;
                            }
                        }
                        else if (m_PlayerColor.equals("b"))
                        {
                            if (NodesAnalysis4[counter4][0] >= NodesAnalysis3[NodesAnalysis4[counter4][1]][0])
                            {
                                NodesAnalysis3[NodesAnalysis4[counter4][1]][0] = NodesAnalysis4[counter4][0];
                                // v0.992: Best variant move text propagation
                                //NodesAnalysis3_MoveText[Int32.Parse(NodesAnalysis4[counter4, 1].ToString())] = String.Concat(NodesAnalysis3_MoveText[Int32.Parse(NodesAnalysis4[counter4, 1].ToString())].ToString(), " , ", NodesAnalysis4_MoveText[counter4].ToString());
                                //bestNode4 = counter4;
                                //bestNodes4[parentNodeAnalyzed] = counter4;
                            }
                        }
                    }

                    // Move 3 level (Human)

                    //v0.992: Comment out this line if Thinking_Depth is set to 4!
                    //parentNodeAnalyzed = -999;

                    //v0.992: Calculate the average value in every path to find the best move
                    //#region AverageScore
                    //for (counter3 = 1; counter3 <= NodeLevel_3_count; counter3++)
                    //{
                    //    NodesAnalysis3[counter3, 0] =
                    //        (NodesAnalysis3[counter3, 0]
                    //        + NodesAnalysis2[Int32.Parse(NodesAnalysis3[counter3, 1].ToString()), 0]
                    //        + NodesAnalysis1[Int32.Parse(NodesAnalysis2[Int32.Parse(NodesAnalysis3[counter3, 1].ToString()), 1].ToString()), 0]
                    //        + NodesAnalysis0[NodesAnalysis1[Int32.Parse(NodesAnalysis2[Int32.Parse(NodesAnalysis3[counter3, 1].ToString()), 1].ToString()), 1], 0]) / 4;
                    //}
                    //#endregion AverageScore

                    // v0.990: Move 4 changes
                    // v0.991: Start from 0!
                    for (counter3 = 0; counter3 < NodeLevel_3_count; counter3++)
                    {
                        if (NodesAnalysis3[counter3][1] != parentNodeAnalyzed)
                        {
                            //parentNodeAnalyzedchanged = true;
                            parentNodeAnalyzed = NodesAnalysis3[counter3][1];
                            NodesAnalysis2[NodesAnalysis3[counter3][1]][0] = NodesAnalysis3[counter3][0];
                            // v0.992: Best variant move text propagation
                            //NodesAnalysis2_MoveText[Int32.Parse(NodesAnalysis3[counter3, 1].ToString())] = String.Concat(NodesAnalysis2_MoveText[Int32.Parse(NodesAnalysis3[counter3, 1].ToString())].ToString(), " , ", NodesAnalysis3_MoveText[counter3].ToString());
                            //bestNode3 = counter3;
                            //bestNodes3[parentNodeAnalyzed] = counter3;
                        }

                        //v0.990: Do we need to check for "<=" here? Os should we start checking for ">="?
                        //v0.992: Fixed to work as the code in the node 2
                        if (m_PlayerColor.equals("w"))
                        {
                            if (NodesAnalysis3[counter3][0] >= NodesAnalysis2[NodesAnalysis3[counter3][1]][0])
                            {
                                NodesAnalysis2[NodesAnalysis3[counter3][1]][0] = NodesAnalysis3[counter3][0];
                                // v0.992: Best variant move text propagation
                                //NodesAnalysis2_MoveText[Int32.Parse(NodesAnalysis3[counter3, 1].ToString())] = String.Concat(NodesAnalysis2_MoveText[Int32.Parse(NodesAnalysis3[counter3, 1].ToString())].ToString(), " , ", NodesAnalysis3_MoveText[counter3].ToString());
                                //bestNode3 = counter3;
                                //bestNodes3[parentNodeAnalyzed] = counter3;
                            }
                        }
                        else if (m_PlayerColor.equals("b"))
                        {
                            if (NodesAnalysis3[counter3][0] <= NodesAnalysis2[NodesAnalysis3[counter3][1]][0])
                            {
                                NodesAnalysis2[NodesAnalysis3[counter3][1]][0] = NodesAnalysis3[counter3][0];
                                // v0.992: Best variant move text propagation
                                //NodesAnalysis2_MoveText[Int32.Parse(NodesAnalysis3[counter3, 1].ToString())] = String.Concat(NodesAnalysis2_MoveText[Int32.Parse(NodesAnalysis3[counter3, 1].ToString())].ToString(), " , ", NodesAnalysis3_MoveText[counter3].ToString());
                                //bestNode3 = counter3;
                                //bestNodes3[parentNodeAnalyzed] = counter3;
                            }

                        }
                    }

                }
                
                // Move 2 level (Computer) -- The analysis starts from here if Thinking_Depth = 2.
                //parentNodeAnalyzed = -999;
                        
                // v0.991: Start from 0!
                // v0.991: Use "counter2 < NodeLevel_2_count" instead of "counter2 <= NodeLevel_2_count"!
                for (counter2 = 0; counter2 < NodeLevel_2_count; counter2++)
                {
                        if (NodesAnalysis2[counter2][1] != parentNodeAnalyzed)
                        {
                                //parentNodeAnalyzedchanged = true;
                                parentNodeAnalyzed = NodesAnalysis2[counter2][1];
                                NodesAnalysis1[NodesAnalysis2[counter2][1]][0] = NodesAnalysis2[counter2][0];
                        }

                        if (m_PlayerColor.equals("w"))
                        {
                            if (NodesAnalysis2[counter2][0] <= NodesAnalysis1[NodesAnalysis2[counter2][1]][0])
                            {
                                    NodesAnalysis1[NodesAnalysis2[counter2][1]][0] = NodesAnalysis2[counter2][0];
                            }
                        }
                        else if (m_PlayerColor.equals("b"))
                        {
                            if (NodesAnalysis2[counter2][0] >= NodesAnalysis1[NodesAnalysis2[counter2][1]][0])
                            {
                                    NodesAnalysis1[NodesAnalysis2[counter2][1]][0] = NodesAnalysis2[counter2][0];
                            }
                        }
                }

                // Now the Node1 level is filled with the score data
                // this is line 1 in the shape at http://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Minimax.svg/300px-Minimax.svg.png
                // V0.992: Comment out parentNodeAnalyzed = -999;
                //parentNodeAnalyzed = -999;

                for (counter1 = 0; counter1 < NodeLevel_1_count; counter1++)
                {
                        if (NodesAnalysis1[counter1][1] != parentNodeAnalyzed)
                        {
                                //parentNodeAnalyzedchanged = true;
                                parentNodeAnalyzed = NodesAnalysis1[counter1][1];
                                NodesAnalysis0[NodesAnalysis1[counter1][1]][0] = NodesAnalysis1[counter1][0];
                        }

                        if (m_PlayerColor.equals("w"))
                        {
                            if (NodesAnalysis1[counter1][0] >= NodesAnalysis0[NodesAnalysis1[counter1][1]][0])
                            {
                                    NodesAnalysis0[NodesAnalysis1[counter1][1]][0] = NodesAnalysis1[counter1][0];
                            }
                        }
                        else if (m_PlayerColor.equals("b"))
                        {
                            if (NodesAnalysis1[counter1][0] <= NodesAnalysis0[NodesAnalysis1[counter1][1]][0])
                            {
                                    NodesAnalysis0[NodesAnalysis1[counter1][1]][0] = NodesAnalysis1[counter1][0];
                            }
                        }
                }

                // Choose the biggest score at the Node0 level
                // Check example at http://en.wikipedia.org/wiki/Minimax#Example_2
                // This is line 0 at the shape at http://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Minimax.svg/300px-Minimax.svg.png

                // Initialize the score with the first score and move found
                double temp_score = NodesAnalysis0[0][0];
                Best_Move_StartingColumnNumber = NodesAnalysis0[0][2];
                Best_Move_StartingRank = NodesAnalysis0[0][4];
                Best_Move_FinishingColumnNumber = NodesAnalysis0[0][3];
                Best_Move_FinishingRank = NodesAnalysis0[0][5];

                for (counter0 = 0; counter0 < NodeLevel_0_count; counter0++)
                {
                    //v0.992: Add a penalty if the move is the same as the previous one, so as to avoid threefold repetition!
                    //(if the finishing column and rank is the same as the starting column and rank of the previous move and the moving piece is the same)
                    if ((NodesAnalysis0[(counter0)][(3)] == prev_Best_Move_StartingColumnNumber) &&
                       (NodesAnalysis0[(counter0)][(5)] == prev_Best_Move_StartingRank) &&
                       (MovingPiece.equals(prev_MovingPiece)))
                    {
                        if (m_PlayerColor.equals("b"))
                        {
                            NodesAnalysis0[(counter0)][(0)] = NodesAnalysis0[(counter0)][(0)] - 10;
                        }
                        else if (m_PlayerColor.equals("w"))
                        {
                            NodesAnalysis0[(counter0)][(0)] = NodesAnalysis0[(counter0)][(0)] + 10;
                        }
                    }
                    
                    if (m_PlayerColor.equals("b"))
                    {
                        if (NodesAnalysis0[counter0][0] > temp_score)
                        {
                                temp_score = NodesAnalysis0[counter0][0];

                                Best_Move_StartingColumnNumber = NodesAnalysis0[counter0][2];
                                Best_Move_StartingRank = NodesAnalysis0[counter0][4];
                                Best_Move_FinishingColumnNumber = NodesAnalysis0[counter0][3];
                                Best_Move_FinishingRank = NodesAnalysis0[counter0][5];
                        }
                    }
                    else if (m_PlayerColor.equals("w"))
                    {
                        if (NodesAnalysis0[counter0][0] < temp_score)
                        {
                                temp_score = NodesAnalysis0[counter0][0];

                                Best_Move_StartingColumnNumber = NodesAnalysis0[counter0][2];
                                Best_Move_StartingRank = NodesAnalysis0[counter0][4];
                                Best_Move_FinishingColumnNumber = NodesAnalysis0[counter0][3];
                                Best_Move_FinishingRank = NodesAnalysis0[counter0][5];
                        }
                    }
                }

        }
        
        //v0.992: If mate is found, go for it!
        if (Mate_Found == true)
        {
            Best_Move_StartingColumnNumber = m_StartingColumnNumber_mate;
            Best_Move_FinishingColumnNumber = m_FinishingColumnNumber_mate;
            Best_Move_StartingRank = m_StartingRank_mate;
            Best_Move_FinishingRank = m_FinishingRank_mate;
        }

        //v0.992
        //Store the best move starting column and rank, so that the move is not repeated next time
        //(see above - this was added to remove the possibility of threefold repetition)
        prev_MovingPiece = MovingPiece;
        prev_Best_Move_StartingColumnNumber = Best_Move_StartingColumnNumber;
        prev_Best_Move_StartingRank = Best_Move_StartingRank;

        /////////////////////////////////////////////////////////////////////////////////////////////////
        // REDRAW THE CHESSBOARD
        /////////////////////////////////////////////////////////////////////////////////////////////////

        //v0.981: If no move found => Resign. If best move found => OK. Go do it.
        if (Best_Move_StartingColumnNumber > 0)
        {
                MovingPiece = Skakiera[(Best_Move_StartingColumnNumber - 1)][(Best_Move_StartingRank - 1)];
                Skakiera[(Best_Move_StartingColumnNumber - 1)][(Best_Move_StartingRank - 1)] = "";

                if (Best_Move_StartingColumnNumber == 1)
                {
                        HY_Starting_Column_Text = "a";
                }
                else if (Best_Move_StartingColumnNumber == 2)
                {
                        HY_Starting_Column_Text = "b";
                }
                else if (Best_Move_StartingColumnNumber == 3)
                {
                        HY_Starting_Column_Text = "c";
                }
                else if (Best_Move_StartingColumnNumber == 4)
                {
                        HY_Starting_Column_Text = "d";
                }
                else if (Best_Move_StartingColumnNumber == 5)
                {
                        HY_Starting_Column_Text = "e";
                }
                else if (Best_Move_StartingColumnNumber == 6)
                {
                        HY_Starting_Column_Text = "f";
                }
                else if (Best_Move_StartingColumnNumber == 7)
                {
                        HY_Starting_Column_Text = "g";
                }
                else if (Best_Move_StartingColumnNumber == 8)
                {
                        HY_Starting_Column_Text = "h";
                }

                // Position piece to the square of destination

                Skakiera[(Best_Move_FinishingColumnNumber - 1)][(Best_Move_FinishingRank - 1)] = MovingPiece;

                if (Best_Move_FinishingColumnNumber == 1)
                {
                        HY_Finishing_Column_Text = "a";
                }
                else if (Best_Move_FinishingColumnNumber == 2)
                {
                        HY_Finishing_Column_Text = "b";
                }
                else if (Best_Move_FinishingColumnNumber == 3)
                {
                        HY_Finishing_Column_Text = "c";
                }
                else if (Best_Move_FinishingColumnNumber == 4)
                {
                        HY_Finishing_Column_Text = "d";
                }
                else if (Best_Move_FinishingColumnNumber == 5)
                {
                        HY_Finishing_Column_Text = "e";
                }
                else if (Best_Move_FinishingColumnNumber == 6)
                {
                        HY_Finishing_Column_Text = "f";
                }
                else if (Best_Move_FinishingColumnNumber == 7)
                {
                        HY_Finishing_Column_Text = "g";
                }
                else if (Best_Move_FinishingColumnNumber == 8)
                {
                        HY_Finishing_Column_Text = "h";
                }

                // v0.9921
                // Check if castling occured (so as to move the rook next to the moving king)
                if (m_PlayerColor.equals("b"))
                {
                    if ((MovingPiece.equals("WK")) &&
                        (Best_Move_StartingColumnNumber == 5) &&
                        (Best_Move_StartingRank == 1) &&
                        (Best_Move_FinishingColumnNumber == 7) &&
                        (Best_Move_FinishingRank == 1))
                    {
                        Skakiera[(5)][(0)] = "WR";
                        Skakiera[(7)][(0)] = "";
                        White_Castling_Occured = true;
                        //MessageBox.Show( "Ο λευκός κάνει μικρό ροκε." );
                    }
                    else if ((MovingPiece.equals("WK")) &&
                            (Best_Move_StartingColumnNumber == 5) &&
                            (Best_Move_StartingRank == 1) &&
                            (Best_Move_FinishingColumnNumber == 3) &&
                            (Best_Move_FinishingRank == 1))
                    {
                        Skakiera[(3)][(0)] = "WR";
                        Skakiera[(0)][(0)] = "";
                        White_Castling_Occured = true;
                        //MessageBox.Show( "Ο λευκός κάνει μεγάλο ροκε." );
                    }
                }
                else if (m_PlayerColor.equals("w"))
                {
                    if ((MovingPiece.equals("BK")) &&
                            (Best_Move_StartingColumnNumber == 5) &&
                            (Best_Move_StartingRank == 8) &&
                            (Best_Move_FinishingColumnNumber == 7) &&
                            (Best_Move_FinishingRank == 8))
                    {
                        Skakiera[(5)][(7)] = "BR";
                        Skakiera[(7)][(7)] = "";
                        Black_Castling_Occured = true;
                        //MessageBox.Show( "Ο μαύρος κάνει μικρό ροκε." );
                    }
                    else if ((MovingPiece.equals("BK")) &&
                            (Best_Move_StartingColumnNumber == 5) &&
                            (Best_Move_StartingRank == 8) &&
                            (Best_Move_FinishingColumnNumber == 3) &&
                            (Best_Move_FinishingRank == 8))
                    {
                        Skakiera[(3)][(7)] = "BR";
                        Skakiera[(0)][(7)] = "";
                        Black_Castling_Occured = true;
                        //MessageBox.Show( "Ο μαύρος κάνει μεγάλο ροκε." );
                    }
                }

                // If king is moved, no castling can occur
                //v0.980: Removed all this code! It is not used anyway!
                //v0.9921: The code is used again!
                if (MovingPiece.equals("WK"))
                    White_King_Moved = true;
                else if (MovingPiece.equals("BK"))
                    Black_King_Moved = true;
                
                // Is there a pawn to promote?
                if ((MovingPiece.equals("WP")) || (MovingPiece.equals("BP")))
                {
                        if (Best_Move_FinishingRank == 8)
                        {
                                Skakiera[(Best_Move_FinishingColumnNumber - 1)][(Best_Move_FinishingRank - 1)] = "WQ";
                                System.out.println("Queen!");
                                //Console.WriteLine("Queen!");
                        }
                        else if (Best_Move_FinishingRank == 1)
                        {
                                Skakiera[(Best_Move_FinishingColumnNumber - 1)][(Best_Move_FinishingRank - 1)] = "BQ";
                                System.out.println("Queen!");
                                //Console.WriteLine("Queen!");
                        }
                }

                //v0.980: No need to have NextLine
                //NextLine = String.Concat(HY_Starting_Column_Text, Best_Move_StartingRank.toString(), " -> ", HY_Finishing_Column_Text, Best_Move_FinishingRank.toString());
                System.out.println("My move: " + HY_Starting_Column_Text + Best_Move_StartingRank + " -> " + HY_Finishing_Column_Text + Best_Move_FinishingRank);
                drawPosition();

                number_of_moves_analysed = 0;

                // Now it is the other color's turn to play
                if (m_PlayerColor.equals("b"))
                {
                        m_WhichColorPlays = "Black";
                        //Move = Move + 1;
                }
                else if (m_PlayerColor.equals("w"))
                {
                        m_WhichColorPlays = "White";
                }

                //v0.9921: Increase move. Use Move_Number_Global!
                Move = Move + 1;
                Move_Number_Global = Move_Number_Global + 1;
                    
                // Now it is the Human's turn to play
                m_WhoPlays = "Human";

                EnterMove();
        }
        //v0.981: If no move found => Resign
        else
        {
                //JOptionPane.showMessageDialog(null, "I resign!");
                 System.out.println("I resign!");
                //Console.WriteLine("I resign!");
        }
}
  
  // Function to measure the score of a position in the chessboard
public static int CountScore(String[][] skakieraCS) {
int score = 0;
 
//int Score_Multiplier = 1;
int Score_Multiplier_White = 1;
int Score_Multiplier_Black = 1;
int WhiteKingColumnCS = 0;
int WhiteKingRankCS = 0;
int BlackKingColumn = 0;
int BlackKingRank = 0;
                
//v0.992
//Detect the kings
for (i = 0; i <= 7; i++)
{
    for (j = 0; j <= 7; j++)
    {
        if (skakieraCS[(i)][(j)].equals("WK"))
        {
            WhiteKingColumnCS = i;
            WhiteKingRankCS = j;
        }
        if (skakieraCS[(i)][(j)].equals("BK"))
        {
            BlackKingColumn = i;
            BlackKingRank = j;
        }
    }
}
                
// v0.991: Have the stupid move generate penalty in the score, without blocking the analysis of moves (all the moves are analyzed)!
if (ThisIsStupidMove.equals("Y"))
{
   //System.out.println("Stupid move:" + m_StartingColumnNumber + m_StartingRank + m_FinishingColumnNumber + m_FinishingRank);
    
   if (m_PlayerColor.equals("w"))
       score = score + 1;
   else if (m_PlayerColor.equals("b"))
       score = score - 1;
}

// v0.991: Added a penalty for moving to dangerous square, without blocking the analysis of moves (all the moves are analyzed)!
if (Skakiera_Dangerous_Squares[(m_FinishingColumnNumber - 1)][(m_FinishingRank - 1)] != 0)
{
   if (m_PlayerColor.equals("w"))
       score = score + 1;
   else if (m_PlayerColor.equals("b"))
       score = score - 1;
}

// v0.991: Add points if possibility to eat is true
if ((possibility_to_eat == true))
{
   if (m_PlayerColor.equals("w"))
       score = score - 1;
   else if (m_PlayerColor.equals("b"))
       score = score + 1;
}
            
   // Scan the chessboard
  for (int i = 0; i < 8; i++)
  {
    for (int j = 0; j < 8; j++)
    {
      // Increase the score for any white piece you find
      if (skakieraCS[i][j].equals("WR"))
      {
         score = score + 50 * Score_Multiplier_White;
         
         //v0.992
         // Get near the King at the ending...
         if ((Move_Number_Global > 40) && (Math.abs(i - BlackKingColumn) < 4))
         {
             score = score + 1 * Score_Multiplier_White;
         }
         if ((Move_Number_Global > 40) && (Math.abs(j - BlackKingRank) < 4))
         {
             score = score + 1 * Score_Multiplier_White;
         }
      }
      else if (skakieraCS[i][j].equals("WN"))
      {
         score = score + 30 * Score_Multiplier_White;
         
         // Get near the King at the ending...
         if ((Move_Number_Global > 40) && (Math.abs(i - BlackKingColumn) < 4))
         {
             score = score + 1 * Score_Multiplier_White;
         }
         if ((Move_Number_Global > 40) && (Math.abs(j - BlackKingRank) < 4))
         {
             score = score + 1 * Score_Multiplier_White;
         }
      }
      else if (skakieraCS[i][j].equals("WB"))
      {
         score = score + 30 * Score_Multiplier_White;
         
         // Get near the King at the ending...
         if ((Move_Number_Global > 40) && (Math.abs(i - BlackKingColumn) < 4))
         {
             score = score + 1 * Score_Multiplier_White;
         }
         if ((Move_Number_Global > 40) && (Math.abs(j - BlackKingRank) < 4))
         {
             score = score + 1 * Score_Multiplier_White;
         }
      }
      else if (skakieraCS[i][j].equals("WQ"))
      {
         score = score + 90 * Score_Multiplier_White;

         // Get near the King at the ending...
         if ((Move_Number_Global > 40) && (Math.abs(i - BlackKingColumn) < 3))
         {
             score = score + 1 * Score_Multiplier_White;
         }
         if ((Move_Number_Global > 40) && (Math.abs(j - BlackKingRank) < 3))
         {
             score = score + 1 * Score_Multiplier_White;
         }
      }
      else if (skakieraCS[i][j].equals("WK"))
         score = score + 150 * Score_Multiplier_White;
      else if (skakieraCS[i][j].equals("WP"))
      {
         score = score + 10 * Score_Multiplier_White; 
         
        //Advanced pawns
        if ((Move_Number_Global > 40) && (j > 3))
        {
            score = score + j * Score_Multiplier_White;
        }
      }
      // Derease the score for any black piece you find
      else if (skakieraCS[i][j].equals("BR"))
      {
         score = score - 50 * Score_Multiplier_Black;

         // Get near the King at the ending...
         if ((Move_Number_Global > 40) && (Math.abs(i - WhiteKingColumnCS) < 4))
         {
             score = score - 1 * Score_Multiplier_Black;
         }
         if ((Move_Number_Global > 40) && (Math.abs(j - WhiteKingRankCS) < 4))
         {
             score = score - 1 * Score_Multiplier_Black;
         }
      }
      else if (skakieraCS[i][j].equals("BN"))
      {
         score = score - 30 * Score_Multiplier_Black;

         // Get near the King at the ending...
         if ((Move_Number_Global > 40) && (Math.abs(i - WhiteKingColumnCS) < 4))
         {
             score = score - 1 * Score_Multiplier_Black;
         }
         if ((Move_Number_Global > 40) && (Math.abs(j - WhiteKingRankCS) < 4))
         {
             score = score - 1 * Score_Multiplier_Black;
         }
      }
      else if (skakieraCS[i][j].equals("BB"))
      {
         score = score - 30 * Score_Multiplier_Black;

         // Get near the King at the ending...
         if ((Move_Number_Global > 40) && (Math.abs(i - WhiteKingColumnCS) < 4))
         {
             score = score - 1 * Score_Multiplier_Black;
         }
         if ((Move_Number_Global > 40) && (Math.abs(j - WhiteKingRankCS) < 4))
         {
             score = score - 1 * Score_Multiplier_Black;
         }
      }
      else if (skakieraCS[i][j].equals("BQ"))
      {
         score = score - 90 * Score_Multiplier_Black;

         // Get near the King at the ending...
         if ((Move_Number_Global > 40) && (Math.abs(i - WhiteKingColumnCS) < 3))
         {
             score = score - 1 * Score_Multiplier_Black;
         }
         if ((Move_Number_Global > 40) && (Math.abs(j - WhiteKingRankCS) < 3))
         {
             score = score - 1 * Score_Multiplier_Black;
         }
      }
      else if (skakieraCS[i][j].equals("BK"))
      {
         score = score - 150 * Score_Multiplier_Black;
      }
      else if (skakieraCS[i][j].equals("BP"))
      {
         score = score - 10 * Score_Multiplier_Black;
         
         // Advanced pawns
         if ((Move_Number_Global > 40) && (j < 4))
         {
             score = score - j * Score_Multiplier_Black;
         }
      }
    }
  }
  
  // Position Quality Checks
  // Take the center with the pawns
  if (Move_Number_Global < 16)
  {
      if (skakieraCS[3][3].equals("WP"))
      {
          score = score + 1;
      }
      if (skakieraCS[4][3].equals("WP"))
      {
          score = score + 1;
      }
      if (skakieraCS[3][4].equals("BP"))
      {
          score = score - 1;
      }
      if (skakieraCS[4][4].equals("BP"))
      {
          score = score - 1;
      }
  }

  // Don't make stupid moves in the beginning
  if (Move_Number_Global < 10)
  {
      // WHITE PIECES
      // Move the knight
      if (skakieraCS[1][0].equals("WN"))
      {
          score = score - 1;
      }
      if (skakieraCS[6][0].equals("WN"))
      {
          score = score - 1;
      }
      // Move the bishop
      if (skakieraCS[2][0].equals("WB"))
      {
          score = score - 1;
      }
      if (skakieraCS[5][0].equals("WB"))
      {
          score = score - 1;
      }
      // Do not move the rook
      if (skakieraCS[0][0].equals(""))
      {
          score = score - 1;
      }
      if (skakieraCS[7][0].equals(""))
      {
          score = score - 1;
      }
      // Do not make stupid moves with knights
      if (skakieraCS[0][2].equals("WN"))
      {
          score = score - 1;
      }
      if (skakieraCS[7][2].equals("WN"))
      {
          score = score - 1;
      }
      // Do not make stupid moves with pawns
      if (skakieraCS[0][3].equals("WP"))
      {
          score = score - 1;
      }
      if (skakieraCS[7][3].equals("WP"))
      {
          score = score - 1;
      }

      // BLACK PIECES
      // Move the knight
      if (skakieraCS[1][7].equals("BN"))
      {
          score = score + 1;
      }
      if (skakieraCS[6][7].equals("BN"))
      {
          score = score + 1;
      }
      // Move the bishop
      if (skakieraCS[2][7].equals("BB"))
      {
          score = score + 1;
      }
      if (skakieraCS[5][7].equals("BB"))
      {
          score = score + 1;
      }
      // Do not move the rook
      if (skakieraCS[0][7].equals(""))
      {
          score = score + 1;
      }
      if (skakieraCS[7][7].equals(""))
      {
          score = score + 1;
      }
      // Do not make stupid moves with knights
      if (skakieraCS[0][5].equals("BN"))
      {
          score = score + 1;
      }
      if (skakieraCS[7][5].equals("BN"))
      {
          score = score + 1;
      }
      // Do not make stupid moves with pawns
      if (skakieraCS[0][4].equals("BP"))
      {
          score = score + 1;
      }
      if (skakieraCS[7][4].equals("BP"))
      {
          score = score + 1;
      }
  }

  // v0.992
  // Check for check
  WhiteKingCheck = CheckForWhiteCheck(skakieraCS);
  BlackKingCheck = CheckForBlackCheck(skakieraCS);

  // Finale...
  if (Move_Number_Global > 40)
  {
      //Checking is a good thing...
      //(but not too much)
      if (WhiteKingCheck == true)
      {
          score = score - 1 * Score_Multiplier_Black;
      }
      if (BlackKingCheck == true)
      {
          score = score + 1 * Score_Multiplier_White;
      }
  }
 
  System.out.println("Score returned:" + score);
  
 return score;
  }
   
public static boolean ElegxosNomimotitas(String[][] ENSkakiera, int checkForDanger, int startRank, int startColumn, int finishRank, int finishColumn, String MovingPiece_2)              
    {												         
    // TODO: Add your control notification handler code here

    boolean Nomimotita;
    //Console.WriteLine("into Elegxos Nomimotitas");
    
    String ProsorinoKommati_EN;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Έλεγχος της "ΝΟΜΙΜΟΤΗΤΑΣ" της κίνησης. Αν π.χ. ο χρήστης έχει επιλέξει να κινήσει έναν πύργο από
	// το α2 στο α5, αλλά στο α4 υπάρχει κάποιο πιόνι του, τότε η Nomimotita έχει τιμή false.
	// Η συνάρτηση "επιστρέφει" τη booleanean μεταβλητή Nomimotita.
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	Nomimotita = true;

	if( ((finishRank-1) > 7) || ((finishRank-1) < 0) || ((finishColumn-1) > 7) || ((finishColumn-1) < 0) )
		Nomimotita = false;

	// if a piece of the same colout is in the destination square...
    if (checkForDanger == 0)
    {
        if ((MovingPiece_2.equals("WK")) || (MovingPiece_2.equals("WQ")) || (MovingPiece_2.equals("WR")) || (MovingPiece_2.equals("WN")) || (MovingPiece_2.equals("WB")) || (MovingPiece_2.equals("WP")))
        {
            if ((ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("WK")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("WQ")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("WR")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("WN")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("WB")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("WP")))
            {
                Nomimotita = false;
            }
        }
        else if ((MovingPiece_2.equals("BK")) || (MovingPiece_2.equals("BQ")) || (MovingPiece_2.equals("BR")) || (MovingPiece_2.equals("BN")) || (MovingPiece_2.equals("BB")) || (MovingPiece_2.equals("BP")))
        {
            if ((ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("BK")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("BQ")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("BR")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("BN")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("BB")) || (ENSkakiera[((finishColumn - 1))][((finishRank - 1))].equals("BP")))
                Nomimotita = false;
        }
    }

	if (MovingPiece_2.equals("WK"))
	{
        if (checkForDanger == 0)
        {
            /////////////////////////
            // WK
            /////////////////////////
            // is the king threatened in the destination square?
            // temporarily move king
            ENSkakiera[(startColumn - 1)][(startRank - 1)] = "";
            ProsorinoKommati_KingCheck = ENSkakiera[(finishColumn - 1)][(finishRank - 1)];
            ENSkakiera[(finishColumn - 1)][(finishRank - 1)] = "WK";
            
            WhiteKingCheck = CheckForWhiteCheck(ENSkakiera);

            if (WhiteKingCheck == true)
                Nomimotita = false;

            // restore pieces
            ENSkakiera[(startColumn - 1)][(startRank - 1)] = "WK";
            ENSkakiera[(finishColumn - 1)][(finishRank - 1)] = ProsorinoKommati_KingCheck;
        }
	}
	else if (MovingPiece_2.equals("BK"))
	{
        if (checkForDanger == 0)
        {
            ///////////////////////////
            // BK
            ///////////////////////////
            // is the BK threatened in the destination square?
            // temporarily move king
            ENSkakiera[(startColumn - 1)][(startRank - 1)] = "";
            ProsorinoKommati_KingCheck = ENSkakiera[(finishColumn - 1)][(finishRank - 1)];
            ENSkakiera[(finishColumn - 1)][(finishRank - 1)] = "BK";

            BlackKingCheck = CheckForBlackCheck(ENSkakiera);

            if (BlackKingCheck == true)
            {
                Nomimotita = false;
            }
            
            // restore pieces
            ENSkakiera[(startColumn - 1)][(startRank - 1)] = "BK";
            ENSkakiera[(finishColumn - 1)][(finishRank - 1)] = ProsorinoKommati_KingCheck;
        }
	}
	else if (MovingPiece_2.equals("WP"))
	{
        if (checkForDanger == 0)
        {
            //Console.WriteLine("checking WP");
            //System.out.println("Checkpoint 2");
            
            /////////////////////
            // WP
            /////////////////////

            // move forward

            if ((finishRank == (startRank + 1)) && (finishColumn == startColumn))
            {
                if (!ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals(""))
                {
                    //Console.WriteLine("pawn Nomimotita false");
                    Nomimotita = false;
                    
                    System.out.println("Checkpoint 2.1 - Wrong move");
                }
            }

            // move forward for 2 squares
            else if ((finishRank == (startRank + 2)) && (finishColumn == startColumn))
            {
                if (startRank == 2)
                {
                    if ((!ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("")) || (!ENSkakiera[(finishColumn - 1)][(finishRank - 1 - 1)].equals("")))
                    {
                        Nomimotita = false;
                        System.out.println("Checkpoint 2.2 - Wrong move");
                        System.out.println("Checkpoint 2.2 - Final square     : " + ENSkakiera[(finishColumn - 1)][(finishRank - 1)]);
                        System.out.println("Checkpoint 2.2 - Pre-final square : " + ENSkakiera[(finishColumn - 1)][(finishRank - 1 - 1)]);
                    }
                }
            }

            // eat forward to the right

            else if ((finishRank == (startRank + 1)) && (finishColumn == startColumn + 1))
            {
                if (enpassant_occured == false)
                {
                    if (ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals(""))
                    {
                        Nomimotita = false;
                        System.out.println("Checkpoint 2.3 - Wrong move");
                    }
                }
            }

            // eat forward to the left

            else if ((finishRank == (startRank + 1)) && (finishColumn == startColumn - 1))
            {
                if (enpassant_occured == false)
                {
                    if (ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals(""))
                    {
                        Nomimotita = false;
                        System.out.println("Checkpoint 2.4 - Wrong move");
                    }
                }
            }
        }
	}
	else if (MovingPiece_2.equals("BP"))
	{
        if (checkForDanger == 0)
        {
            /////////////////////
            // BP
            /////////////////////

            // move forward

            if ((finishRank == (startRank - 1)) && (finishColumn == startColumn))
            {
                if (!ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals(""))
                    Nomimotita = false;
            }

            // move forward for 2 squares
            else if ((finishRank == (startRank - 2)) && (finishColumn == startColumn))
            {
                if (startRank == 7)
                {
                    if ((!ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("")) || (!ENSkakiera[(finishColumn - 1)][(finishRank + 1 - 1)].equals("")))
                        Nomimotita = false;
                }
            }

            // eat forward to the right

            else if ((finishRank == (startRank - 1)) && (finishColumn == startColumn + 1))
            {
                if (enpassant_occured == false)
                {
                    if (ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals(""))
                        Nomimotita = false;
                }
            }

            // eat forward to the left

            else if ((finishRank == (startRank - 1)) && (finishColumn == startColumn - 1))
            {
                if (enpassant_occured == false)
                {
                    if (ENSkakiera[(finishColumn - 1)][(finishRank - 1)].equals(""))
                        Nomimotita = false;
                }
            }
        }
	}
	else if( (MovingPiece_2.equals("WR")) || (MovingPiece_2.equals("WQ")) || (MovingPiece_2.equals("WB")) || (MovingPiece_2.equals("BR")) || (MovingPiece_2.equals("BQ")) || (MovingPiece_2.equals("BB")) )
	{
		h = 0;
		p = 0;
		//hhh = 0;
		how_to_move_Rank = 0;
		how_to_move_Column = 0;

		if(((finishRank-1) > (startRank-1)) || ((finishRank-1) < (startRank-1)))
			how_to_move_Rank = ((finishRank-1) - (startRank-1))/ Math.abs((finishRank-1) - (startRank-1));
			
		if(((finishColumn-1) > (startColumn-1)) || ((finishColumn-1) < (startColumn-1)) )
			how_to_move_Column = ((finishColumn-1) - (startColumn-1))/Math.abs((finishColumn-1) - (startColumn-1));

		exit_elegxos_nomimothtas = false;

		do
		{
			h = h + how_to_move_Rank;
			p = p + how_to_move_Column;

			if( (((startRank-1) + h) == (finishRank-1)) && ((((startColumn-1) + p)) == (finishColumn-1)) )
				exit_elegxos_nomimothtas = true;

			if((startColumn - 1 + p)<0)
				exit_elegxos_nomimothtas = true;
			else if((startRank - 1 + h)<0)
				exit_elegxos_nomimothtas = true;
			else if((startColumn - 1 + p)>7)
				exit_elegxos_nomimothtas = true;
			else if((startRank - 1 + h)>7)
				exit_elegxos_nomimothtas = true;

			// if a piece exists between the initial and the destination square,
			// then the move is illegal!
			if( exit_elegxos_nomimothtas == false )
			{
				if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("WR"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("WN"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("WB"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("WQ"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("WK"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("WP"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				
				if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("BR"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("BN"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("BB"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("BQ"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("BK"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
				else if(ENSkakiera[(startColumn - 1 + p)][(startRank - 1 + h)].equals("BP"))
				{
					Nomimotita = false;
					exit_elegxos_nomimothtas = true;
				}
			}
		}while(exit_elegxos_nomimothtas == false);
	}
        
        // v0.992: The check if there is a check after the move is a check that should be always checked!
        // ATTENTION: This did not work well! Potentially it messed up with a table. So I reverted to the previous situation where the check is done separately in EnterMove and ChecMove.
        // ATTENTION: No, everything is ok! :)
        // Yes: It is done in CheckMove AND EnterMove (for the human player's move)!
        // But it is better to have it centrally and also do it for all moves in the thinking process (not only the first one)!
        // Check for check (do it only for the first two levels of thinking, to speed up thinking)
        if ((Nomimotita == true) && (Move_Analyzed < 2))
        {
            // Check for check (before the move)
            //WhiteKingCheck_before = CheckForWhiteCheck(ENSkakiera);
            //BlackKingCheck_before = CheckForBlackCheck(ENSkakiera);

            // Make the move temporarily
            ENSkakiera[(startColumn - 1)][(startRank - 1)] = "";
            ProsorinoKommati_EN = ENSkakiera[(finishColumn - 1)][(finishRank - 1)];
            ENSkakiera[(finishColumn - 1)][(finishRank - 1)] = MovingPiece_2;

            // Check for check (after the move)

            // m_WhichColorPlays is not updated throughout the app!
            if (m_WhichColorPlays.equals("White"))
            {
                WhiteKingCheck = CheckForWhiteCheck(ENSkakiera);
            }
            else if (m_WhichColorPlays.equals("Black"))
            {
                BlackKingCheck = CheckForBlackCheck(ENSkakiera);
            }

            if ((m_WhichColorPlays.equals("White")) && (WhiteKingCheck == true))
            {
                Nomimotita = false;
            }
            if ((m_WhichColorPlays.equals("Black")) && (BlackKingCheck == true))
            {
                Nomimotita = false;
            }

            //if ((WhiteKingCheck_before == true) && (WhiteKingCheck == true))
            //{
            //    Nomimotita = false;
            //}
            //if ((BlackKingCheck_before == true) && (BlackKingCheck == true))
            //{
            //    Nomimotita = false;
            //}

            // Return pieces to original position (potentially not needed, but let's be consistent and ψείρες)
            ENSkakiera[(finishColumn - 1)][(finishRank - 1)] = ProsorinoKommati_EN; //v0.990 ProsorinoKommati_KingCheck;
            ENSkakiera[(startColumn - 1)][(startRank - 1)] = MovingPiece_2;
        }

        //--------------- v0.9921: Castling -------------------

        // White castling

        // Small castling
        if ((m_WhichColorPlays.equals("White")) &&
            (startColumn == 5) &&
            (finishColumn == 7) &&
            (startRank == 1) &&
            (finishRank == 1) &&
            (White_Castling_Occured == false) &&
            (White_King_Moved == false))
        {
            //MessageBox.Show("Check 1.0");
            if ((ENSkakiera[(startColumn - 1)][(startRank - 1)].equals("WK")) && (ENSkakiera[(7)][(0)].equals("WR")) && (ENSkakiera[(5)][(0)].equals("")) && (ENSkakiera[(6)][(0)].equals("")))
            {
                //m_OrthotitaKinisis = true;
                Nomimotita = true;
                Castling_Move = true;
                //MessageBox.Show("Check 1.1");
            }
        }

        // Big castling
        if ((m_WhichColorPlays.equals("White")) && (startColumn == 5) && (finishColumn == 3) && (startRank == 1) && (finishRank == 1) && (White_Castling_Occured == false) && (White_King_Moved == false))
        {
            if ((ENSkakiera[(startColumn - 1)][(startRank - 1)].equals("WK")) && (ENSkakiera[(0)][(0)].equals("WR")) && (ENSkakiera[(1)][(0)].equals("")) && (ENSkakiera[(2)][(0)].equals("")) && (ENSkakiera[(3)][(0)].equals("")))
            {
                //m_OrthotitaKinisis = true;
                Nomimotita = true;
                Castling_Move = true;
                //MessageBox.Show("Check 1.2");
            }
        }

        // Black castling

        // Small castling
        if ((m_WhichColorPlays.equals("Black")) && (startColumn == 5) && (finishColumn == 7) && (startRank == 8) && (finishRank == 8) && (Black_Castling_Occured == false) && (Black_King_Moved == false))
        {
            if ((ENSkakiera[(startColumn - 1)][(startRank - 1)].equals("BK")) && (ENSkakiera[(7)][(7)].equals("BR")) && (ENSkakiera[(5)][(7)].equals("")) && (ENSkakiera[(6)][(7)].equals("")))
            {
                //m_OrthotitaKinisis = true;
                Nomimotita = true;
                Castling_Move = true;
            }
        }

        // Big castling
        if ((m_WhichColorPlays.equals("Black")) && (startColumn == 5) && (finishColumn == 3) && (startRank == 8) && (finishRank == 8) && (Black_Castling_Occured == false) && (Black_King_Moved == false))
        {
            if ((ENSkakiera[(startColumn - 1)][(startRank - 1)].equals("BK")) && (ENSkakiera[(0)][(7)].equals("BR")) && (ENSkakiera[(1)][(7)].equals("")) && (ENSkakiera[(2)][(7)].equals("")) && (ENSkakiera[(3)][(7)].equals("")))
            {
                //m_OrthotitaKinisis = true;
                Nomimotita = true;
                Castling_Move = true;
            }
        }
        //--------------- v0.9921: Castling -------------------
        
	return Nomimotita;
	}

// FUNCTION TO CHECK THE CORRECTNESS (='Orthotita' in Greek) OF THE MOVE
// (i.e. a Bishop can only move in diagonals, rooks in lines and columns etc)
// The ElegxosOrthotitas "checkForDanger" mode differs from the ElegxosOrthotitas normal mode in that it does not make all the validations
// (since it is used to check for "Dangerous" squares in the chessboard and not to actually judge the correctness of an actual move)
public static boolean ElegxosOrthotitas(String[][] EOSkakiera, int checkForDanger, int startRank, int startColumn, int finishRank, int finishColumn, String MovingPiece_2)
{
    // TODO: Add your control notification handler code here

    // If called for checking dangerous squares, put a virtual piece in the destination square so as to pass the validation checks
    // if (checkForDanger == 1)
    // Don't care about checking for the existence of a piece in the destination square


    boolean Orthotita;
    Orthotita = false;
    enpassant_occured = false;

            //Console.WriteLine("ElegxosOrthotitas");
            //Console.WriteLine(MovingPiece_2);

    //Micro edition 2: Convert small Strings to Int
    //If m_WhoPlays = Human
    if ((m_WhoPlays.equals("Human")) && (m_WrongColumn == false) && (!MovingPiece_2.equals("")))    // Αν ο χρήστης έχει γράψει μία έγκυρη στήλη και έχει
    {                                                         // επιλέξει να κινήσει ένα κομμάτι (και δεν έχει επι-
        // λέξει να κινήσει ένα "κενό" τετράγωνο) και είναι η σειρά του να παίξει, τότε να γί-
        // νει έλεγχος της ορθότητας της κίνησης. 

        //Console.WriteLine("1");

        // ROOK

        if ((MovingPiece_2.equals("WR")) || (MovingPiece_2.equals("BR")))
        {
            if ((finishColumn != startColumn) && (finishRank == startRank))       // Κίνηση σε στήλη
                Orthotita = true;
            else if ((finishRank != startRank) && (finishColumn == startColumn))  // Κίνηση σε γραμμή
                Orthotita = true;
        }

        // horse (with knight...)

        if ((MovingPiece_2.equals("WN")) || (MovingPiece_2.equals("BN")))
        {
            if ((finishColumn == (startColumn + 1)) && (finishRank == (startRank + 2)))
                Orthotita = true;
            else if ((finishColumn == (startColumn + 2)) && (finishRank == (startRank - 1)))
                Orthotita = true;
            else if ((finishColumn == (startColumn + 1)) && (finishRank == (startRank - 2)))
                Orthotita = true;
            else if ((finishColumn == (startColumn - 1)) && (finishRank == (startRank - 2)))
                Orthotita = true;
            else if ((finishColumn == (startColumn - 2)) && (finishRank == (startRank - 1)))
                Orthotita = true;
            else if ((finishColumn == (startColumn - 2)) && (finishRank == (startRank + 1)))
                Orthotita = true;
            else if ((finishColumn == (startColumn - 1)) && (finishRank == (startRank + 2)))
                Orthotita = true;
            else if ((finishColumn == (startColumn + 2)) && (finishRank == (startRank + 1)))
                Orthotita = true;
        }

        // bishop

        if ((MovingPiece_2.equals("WB")) || (MovingPiece_2.equals("BB")))
        {
            ////////////////////
            // 2009 v4 change
            ////////////////////
            //if ((Math.abs(finishColumn - startColumn)) == (Math.abs(finishRank - startRank)))
            //    Orthotita = true;
            if (((Math.abs(finishColumn - startColumn)) == (Math.abs(finishRank - startRank))) && (finishColumn != startColumn) && (finishRank != startRank))
                Orthotita = true;
            ////////////////////
            // 2009 v4 change
            ////////////////////
        }

        // queen

        if ((MovingPiece_2.equals("WQ")) || (MovingPiece_2.equals("BQ")))
        {
            if ((finishColumn != startColumn) && (finishRank == startRank))       // Κίνηση σε στήλη
                Orthotita = true;
            else if ((finishRank != startRank) && (finishColumn == startColumn))  // Κίνηση σε γραμμή
                Orthotita = true;

            ////////////////////
            // 2009 v4 change
            ////////////////////
            // move in diagonals
            //if ((Math.abs(finishColumn - startColumn)) == (Math.abs(finishRank - startRank)))
            //    Orthotita = true;
            if (((Math.abs(finishColumn - startColumn)) == (Math.abs(finishRank - startRank))) && (finishColumn != startColumn) && (finishRank != startRank))
                Orthotita = true;
            ////////////////////
            // 2009 v4 change
            ////////////////////
        }

        // king

        if ((MovingPiece_2.equals("WK")) || (MovingPiece_2.equals("BK")))
        {
            // move in rows and columns

            if ((finishColumn == (startColumn + 1)) && (finishRank == startRank))
                Orthotita = true;
            else if ((finishColumn == (startColumn - 1)) && (finishRank == startRank))
                Orthotita = true;
            else if ((finishRank == (startRank + 1)) && (finishColumn == startColumn))
                Orthotita = true;
            else if ((finishRank == (startRank - 1)) && (finishColumn == startColumn))
                Orthotita = true;

            // move in diagonals

            else if ((finishColumn == (startColumn + 1)) && (finishRank == (startRank + 1)))
                Orthotita = true;
            else if ((finishColumn == (startColumn + 1)) && (finishRank == (startRank - 1)))
                Orthotita = true;
            else if ((finishColumn == (startColumn - 1)) && (finishRank == (startRank - 1)))
                Orthotita = true;
            else if ((finishColumn == (startColumn - 1)) && (finishRank == (startRank + 1)))
                Orthotita = true;

        }

        // WP

        if (MovingPiece_2.equals("WP"))
        {
            // move forward
            //Console.WriteLine("2");
//            System.out.println("Checkpoint 1");
//            System.out.println("startRank =" + startRank);
//            System.out.println("finishRank =" + finishRank);
//            System.out.println("startColumn =" + startColumn);
//            System.out.println("finishColumn =" + finishColumn);

            if ((finishRank == (startRank + 1)) && (finishColumn == startColumn))
            {
                Orthotita = true;
                //System.out.println("Checkpoint 1.1 - Valid move");
            }

            // move forward for 2 squares
            else if ((finishRank == (startRank + 2)) && (finishColumn == startColumn) && (startRank == 2))
            {
                Orthotita = true;
                //System.out.println("Checkpoint 1.2 - Valid move");
            }

            else if ((finishRank == (startRank + 1)) && ((finishColumn == (startColumn - 1)) || (finishColumn == (startColumn + 1))))
            {
                if (checkForDanger == 0)
                {
                    // eat forward to the left
                    if ((finishRank == (startRank + 1)) && (finishColumn == (startColumn - 1)) && ((EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BP")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BR")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BN")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BB")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BQ"))))
                        Orthotita = true;

                    // eat forward to the right
                    if ((finishRank == (startRank + 1)) && (finishColumn == (startColumn + 1)) && ((EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BP")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BR")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BN")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BB")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("BQ"))))
                        Orthotita = true;
                }
                else if (checkForDanger == 1)
                {
                        Orthotita = true;
                }
            }

            // En Passant eat forward to the left
            else if ((finishRank == (startRank + 1)) && (finishColumn == (startColumn - 1)))
            {
                if (checkForDanger == 0)
                {
                    //Console.WriteLine(finishRank.ToString());
                    //Console.WriteLine(finishColumn.ToString());
                    //Console.WriteLine("checking En passant...");
                    if ((finishRank == 6) && (EOSkakiera[(finishColumn - 1)][(4)].equals("BP")))
                    {
                        Orthotita = true;
                        enpassant_occured = true;
                        EOSkakiera[(finishColumn - 1)][(finishRank - 1 - 1)] = "";
                        //Console.WriteLine("En passant true");
                    }
                    else
                    {
                        Orthotita = false;
                        enpassant_occured = false;
                    }
                }
            }

            // En Passant eat forward to the right
            else if ((finishRank == (startRank + 1)) && (finishColumn == (startColumn + 1)))
            {
                if (checkForDanger == 0)
                {
                    if ((finishRank == 6) && (EOSkakiera[(finishColumn - 1)][(4)].equals("BP")))
                    {
                        Orthotita = true;
                        enpassant_occured = true;
                        EOSkakiera[(finishColumn - 1)][(finishRank - 1 - 1)] = "";
                    }
                    else
                    {
                        Orthotita = false;
                        enpassant_occured = false;
                    }
                }
            }

        }


        // BP

        if (MovingPiece_2.equals("BP"))
        {
            // move forward

            if ((finishRank == (startRank - 1)) && (finishColumn == startColumn))
                Orthotita = true;

            // move forward for 2 squares
            else if ((finishRank == (startRank - 2)) && (finishColumn == startColumn) && (startRank == 7))
                Orthotita = true;

            else if ((finishRank == (startRank - 1)) && ((finishColumn == (startColumn + 1)) || (finishColumn == (startColumn - 1))))
            {
                if (checkForDanger == 0)
                {
                    // eat forward to the left
                    if ((finishRank == (startRank - 1)) && (finishColumn == (startColumn + 1)) && ((EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WP")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WR")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WN")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WB")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WQ"))))
                        Orthotita = true;

                    // eat forward to the right
                    if ((finishRank == (startRank - 1)) && (finishColumn == (startColumn - 1)) && ((EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WP")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WR")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WN")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WB")) || (EOSkakiera[(finishColumn - 1)][(finishRank - 1)].equals("WQ"))))
                        Orthotita = true;
                }
                else if (checkForDanger == 1)
                {
                    // eat forward to the left
                    if ((finishRank == (startRank - 1)) && (finishColumn == (startColumn + 1)))
                        Orthotita = true;

                    // eat forward to the right
                    if ((finishRank == (startRank - 1)) && (finishColumn == (startColumn - 1)))
                        Orthotita = true;
                }
            }

            // En Passant eat forward to the left
            else if ((finishRank == (startRank - 1)) && (finishColumn == (startColumn + 1)))
            {
                if (checkForDanger == 0)
                {
                    if ((finishRank == 3) && (EOSkakiera[(finishColumn - 1)][(3)].equals("WP")))
                    {
                        Orthotita = true;
                        enpassant_occured = true;
                        EOSkakiera[(finishColumn - 1)][(finishRank + 1 - 1)] = "";
                    }
                    else
                    {
                        Orthotita = false;
                        enpassant_occured = false;
                    }
                }
            }

            // En Passant eat forward to the right
            else if ((finishRank == (startRank - 1)) && (finishColumn == (startColumn - 1)))
            {
                if (checkForDanger == 0)
                {
                    if ((finishRank == 3) && (EOSkakiera[(finishColumn - 1)][(3)].equals("WP")))
                    {
                        Orthotita = true;
                        enpassant_occured = true;
                        EOSkakiera[(finishColumn - 1)][(finishRank + 1 - 1)] = "";
                    }
                    else
                    {
                        Orthotita = false;
                        enpassant_occured = false;
                    }
                }
            }

        }

    }

    //Console.WriteLine(Orthotita.ToString());
    return Orthotita;
}

public static boolean CheckForWhiteCheck(String[][] WCSkakiera) {
    boolean KingCheck = false;
    
                int klopa;
                int i, j;
                
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Εύρεση των συντεταγμένων του βασιλιά.
                // Αν σε κάποιο τετράγωνο βρεθεί ότι υπάρχει ένας βασιλιάς, τότε απλά καταγράφεται η τιμή του εν λόγω
                // τετραγώνου στις αντίστοιχες μεταβλητές που δηλώνουν τη στήλη και τη γραμμή στην οποία υπάρχει λευκός
                // βασιλιάς.
                // ΠΡΟΣΟΧΗ: Γράφω (i+1) αντί για i και (j+1) αντί για j γιατί το πρώτο στοιχείο του πίνακα WCWCSkakiera[(8),(8)]
                // είναι το WCSkakiera[(0),(0)] και ΟΧΙ το WCSkakiera[(1),(1)]!
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

                for (i = 0; i <= 7; i++)
                {
                    for (j = 0; j <= 7; j++)
                    {

                        if (WCSkakiera[(i)][(j)].equals("WK"))
                        {
                            WhiteKingColumn = (i + 1);
                            WhiteKingRank = (j + 1);
                        }

                    }
                }

                ///////////////////////////////////////////////////////////////
                // Έλεγχος του αν ο λευκός βασιλιάς υφίσταται "σαχ"
                ///////////////////////////////////////////////////////////////

                KingCheck = false;

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Ελέγχουμε αρχικά αν υπάρχει κίνδυνος για το λευκό βασιλιά ΑΠΟ ΤΑ ΔΕΞΙΑ ΤΟΥ. Για να μην βγούμε έξω από τα
                // όρια της WCSkakiera[(8),(8)] έχουμε προσθέσει τον έλεγχο (WhiteKingColumn + 1) <= 8 στο "if". Αρχικά ο "κίνδυνος"
                // από τα "δεξιά" είναι υπαρκτός, άρα DangerFromRight = true. Ωστόσο αν βρεθεί ότι στα δεξιά του λευκού βασι-
                // λιά υπάρχει κάποιο λευκό κομμάτι, τότε δεν είναι δυνατόν ο εν λόγω βασιλιάς να υφίσταται σαχ από τα δεξιά
                // του (αφού θα "προστατεύεται" από το κομμάτι ιδίου χρώματος), οπότε η DangerFromRight = false και ο έλεγχος
                // για απειλές από τα δεξιά σταματάει (για αυτό και έχω προσθέσει την προϋπόθεση (DangerFromRight == true) στα
                // "if" που κάνουν αυτόν τον έλεγχο).
                // Αν όμως δεν υπάρχει κανένα λευκό κομμάτι δεξιά του βασιλιά για να τον προστατεύει, τότε συνεχίζει να
                // υπάρχει πιθανότητα να απειλείται ο βασιλιάς από τα δεξιά του, οπότε ο έλεγχος συνεχίζεται.
                // Σημείωση: Ο έλεγχος γίνεται για πιθανό σαχ από πύργο ή βασίλισσα αντίθετου χρώματος.
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromRight = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingColumn + klopa) <= 8) && (DangerFromRight == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("WQ")))
                            DangerFromRight = false;
                        else if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - 1)].equals("BK")))
                            DangerFromRight = false;
                    }
                }


                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                // Έλεγχος αν υπάρχει κίνδυνος για το λευκό βασιλιά ΑΠΟ ΤΑ ΑΡΙΣΤΕΡΑ ΤΟΥ (από πύργο ή βασίλισσα).
                ///////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromLeft = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingColumn - klopa) >= 1) && (DangerFromLeft == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("WQ")))
                            DangerFromLeft = false;
                        else if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - 1)].equals("BK")))
                            DangerFromLeft = false;
                    }
                }


                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                // Έλεγχος αν υπάρχει κίνδυνος για το λευκό βασιλιά ΑΠΟ ΠΑΝΩ (από πύργο ή βασίλισσα).
                ///////////////////////////////////////////////////////////////////////////////////////////////////////


                DangerFromUp = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingRank + klopa) <= 8) && (DangerFromUp == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("WQ")))
                            DangerFromUp = false;
                        else if ((WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank + klopa - 1)].equals("BK")))
                            DangerFromUp = false;
                    }
                }


                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                // Έλεγχος αν υπάρχει κίνδυνος για το λευκό βασιλιά ΑΠΟ ΚΑΤΩ (από πύργο ή βασίλισσα).
                ///////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromDown = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingRank - klopa) >= 1) && (DangerFromDown == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("WQ")))
                            DangerFromDown = false;
                        else if ((WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn - 1)][(WhiteKingRank - klopa - 1)].equals("BK")))
                            DangerFromDown = false;
                    }
                }


                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Έλεγχος αν υπάρχει κίνδυνος για το λευκό βασιλιά ΑΠΟ ΠΑΝΩ-ΔΕΞΙΑ ΤΟΥ (από βασίλισσα ή αξιωματικό).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromUpRight = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingColumn + klopa) <= 8) && ((WhiteKingRank + klopa) <= 8) && (DangerFromUpRight == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WQ")))
                            DangerFromUpRight = false;
                        else if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BK")))
                            DangerFromUpRight = false;
                    }
                }


                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Έλεγχος αν υπάρχει κίνδυνος για το λευκό βασιλιά ΑΠΟ ΚΑΤΩ-ΑΡΙΣΤΕΡΑ ΤΟΥ (από βασίλισσα ή αξιωματικό).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromDownLeft = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingColumn - klopa) >= 1) && ((WhiteKingRank - klopa) >= 1) && (DangerFromDownLeft == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WQ")))
                            DangerFromDownLeft = false;
                        else if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BK")))
                            DangerFromDownLeft = false;
                    }
                }

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Έλεγχος αν υπάρχει κίνδυνος για το λευκό βασιλιά ΑΠΟ ΚΑΤΩ-ΔΕΞΙΑ ΤΟΥ (από βασίλισσα ή αξιωματικό).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromDownRight = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingColumn + klopa) <= 8) && ((WhiteKingRank - klopa) >= 1) && (DangerFromDownRight == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("WQ")))
                            DangerFromDownRight = false;
                        else if ((WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn + klopa - 1)][(WhiteKingRank - klopa - 1)].equals("BK")))
                            DangerFromDownRight = false;
                    }
                }


                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Έλεγχος αν υπάρχει κίνδυνος για το λευκό βασιλιά ΑΠΟ ΠΑΝΩ-ΑΡΙΣΤΕΡΑ ΤΟΥ (από βασίλισσα ή αξιωματικό).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromUpLeft = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((WhiteKingColumn - klopa) >= 1) && ((WhiteKingRank + klopa) <= 8) && (DangerFromUpLeft == true))
                    {
                        if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BB")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BQ")))
                            KingCheck = true;
                        else if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WP")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("White Rook")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WN")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WB")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("WQ")))
                            DangerFromUpLeft = false;
                        else if ((WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BP")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BR")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BN")) || (WCSkakiera[(WhiteKingColumn - klopa - 1)][(WhiteKingRank + klopa - 1)].equals("BK")))
                            DangerFromUpLeft = false;
                    }
                }



                //////////////////////////////////////////////////////////////////////////
                // Έλεγχος για το αν ο λευκός βασιλιάς απειλείται από πιόνι.
                //////////////////////////////////////////////////////////////////////////

                if (((WhiteKingColumn + 1) <= 8) && ((WhiteKingRank + 1) <= 8))
                {
                    if (WCSkakiera[(WhiteKingColumn + 1 - 1)][(WhiteKingRank + 1 - 1)].equals("BP"))
                    {
                        KingCheck = true;
                    }
                }


                if (((WhiteKingColumn - 1) >= 1) && ((WhiteKingRank + 1) <= 8))
                {
                    if (WCSkakiera[(WhiteKingColumn - 1 - 1)][(WhiteKingRank + 1 - 1)].equals("BP"))
                    {
                        KingCheck = true;
                    }
                }


                ///////////////////////////////////////////////////////////////////////
                // Έλεγχος για το αν ο λευκός βασιλιάς απειλείται από ίππο.
                ///////////////////////////////////////////////////////////////////////

                if (((WhiteKingColumn + 1) <= 8) && ((WhiteKingRank + 2) <= 8))
                    if (WCSkakiera[(WhiteKingColumn + 1 - 1)][(WhiteKingRank + 2 - 1)].equals("BN"))
                        KingCheck = true;

                if (((WhiteKingColumn + 2) <= 8) && ((WhiteKingRank - 1) >= 1))
                    if (WCSkakiera[(WhiteKingColumn + 2 - 1)][(WhiteKingRank - 1 - 1)].equals("BN"))
                        KingCheck = true;

                if (((WhiteKingColumn + 1) <= 8) && ((WhiteKingRank - 2) >= 1))
                    if (WCSkakiera[(WhiteKingColumn + 1 - 1)][(WhiteKingRank - 2 - 1)].equals("BN"))
                        KingCheck = true;

                if (((WhiteKingColumn - 1) >= 1) && ((WhiteKingRank - 2) >= 1))
                    if (WCSkakiera[(WhiteKingColumn - 1 - 1)][(WhiteKingRank - 2 - 1)].equals("BN"))
                        KingCheck = true;

                if (((WhiteKingColumn - 2) >= 1) && ((WhiteKingRank - 1) >= 1))
                    if (WCSkakiera[(WhiteKingColumn - 2 - 1)][(WhiteKingRank - 1 - 1)].equals("BN"))
                        KingCheck = true;

                if (((WhiteKingColumn - 2) >= 1) && ((WhiteKingRank + 1) <= 8))
                    if (WCSkakiera[(WhiteKingColumn - 2 - 1)][(WhiteKingRank + 1 - 1)].equals("BN"))
                        KingCheck = true;

                if (((WhiteKingColumn - 1) >= 1) && ((WhiteKingRank + 2) <= 8))
                    if (WCSkakiera[(WhiteKingColumn - 1 - 1)][(WhiteKingRank + 2 - 1)].equals("BN"))
                        KingCheck = true;

                if (((WhiteKingColumn + 2) <= 8) && ((WhiteKingRank + 1) <= 8))
                    if (WCSkakiera[(WhiteKingColumn + 2 - 1)][(WhiteKingRank + 1 - 1)].equals("BN"))
                        KingCheck = true;

    return KingCheck;
}

public static boolean CheckForBlackCheck(String[][] BCSkakiera) {
    boolean KingCheck = false;
    
                 int klopa;
                 int ik, jk;
                 
                 //System.out.println("");
                 //System.out.println("Entered CheckForBlackCheck");
                 
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Εύρεση των συντεταγμένων του βασιλιά.
                // Αν σε κάποιο τετράγωνο βρεθεί ότι υπάρχει ένας βασιλιάς, τότε απλά καταγράφεται η τιμή του εν λόγω
                // τετραγώνου στις αντίστοιχες μεταβλητές που δηλώνουν τη στήλη και τη γραμμή στην οποία υπάρχει μαύρος
                // βασιλιάς.
                // ΠΡΟΣΟΧΗ: Γράφω (i+1) αντί για i και (j+1) αντί για j γιατί το πρώτο στοιχείο του πίνακα BCSkakiera[(8),(8)]
                // είναι το BCSkakiera[(0),(0)] και ΟΧΙ το BCSkakiera[(1),(1)]!
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

                for (ik = 0; ik <= 7; ik++)
                {
                    for (jk = 0; jk <= 7; jk++)
                    {

                        if (BCSkakiera[(ik)][(jk)].equals("BK"))
                        {
                            BlKingColumn = (ik + 1);
                            BlKingRank = (jk + 1);
                            //System.out.println("Found king at " + (ik + 1) + (jk + 1));
                        }

                    }
                }

                ///////////////////////////////////////////////////////////////
                // Έλεγχος του αν ο μαύρος βασιλιάς υφίσταται "σαχ"
                ///////////////////////////////////////////////////////////////

                KingCheck = false;

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Ελέγχουμε αρχικά αν υπάρχει κίνδυνος για το μαύρο βασιλιά ΑΠΟ ΤΑ ΔΕΞΙΑ ΤΟΥ. Για να μην βγούμε έξω από τα
                // όρια της BCSkakiera[(8),(8)] έχουμε προσθέσει τον έλεγχο (BlKingColumn + 1) <= 8 στο "if". Αρχικά ο "κίνδυνος"
                // από τα "δεξιά" είναι υπαρκτός, άρα DangerFromRight = true. Ωστόσο αν βρεθεί ότι στα δεξιά του μαύρου βασι-
                // λιά υπάρχει κάποιο μαύρο κομμάτι, τότε δεν είναι δυνατόν ο εν λόγω βασιλιάς να υφίσταται σαχ από τα δεξιά
                // του (αφού θα "προστατεύεται" από το κομμάτι ιδίου χρώματος), οπότε η DangerFromRight = false και ο έλεγχος
                // για απειλές από τα δεξιά σταματάει (για αυτό και έχω προσθέσει την προϋπόθεση (DangerFromRight == true) στα
                // "if" που κάνουν αυτόν τον έλεγχο).
                // Αν όμως δεν υπάρχει κανένα μαύρο κομμάτι δεξιά του βασιλιά για να τον προστατεύει, τότε συνεχίζει να
                // υπάρχει πιθανότητα να απειλείται ο βασιλιάς από τα δεξιά του, οπότε ο έλεγχος συνεχίζεται.
                // Σημείωση: Ο έλεγχος γίνεται για πιθανό σαχ από πύργο ή βασίλισσα αντίθετου χρώματος.
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromRight = true;
                
                //System.out.println("BlKingColumn = " + BlKingColumn);
                //System.out.println("BlKingRank = " + BlKingRank);

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingColumn + klopa) <= 8) && (DangerFromRight == true))
                    {
                        if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("BQ")))
                            DangerFromRight = false;
                        else if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - 1)].equals("WK")))
                            DangerFromRight = false;
                    }
                }

                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                // Έλεγχος αν υπάρχει κίνδυνος για το μαύρο βασιλιά ΑΠΟ ΤΑ ΑΡΙΣΤΕΡΑ ΤΟΥ (από πύργο ή βασίλισσα).
                ///////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromLeft = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingColumn - klopa) >= 1) && (DangerFromLeft == true))
                    {
                        if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("BQ")))
                            DangerFromLeft = false;
                        else if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - 1)].equals("WK")))
                            DangerFromLeft = false;
                    }
                }



                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                // Έλεγχος αν υπάρχει κίνδυνος για το μαύρο βασιλιά ΑΠΟ ΠΑΝΩ (από πύργο ή βασίλισσα).
                ///////////////////////////////////////////////////////////////////////////////////////////////////////


                DangerFromUp = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingRank + klopa) <= 8) && (DangerFromUp == true))
                    {
                        if ((BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("BQ")))
                            DangerFromUp = false;
                        else if ((BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank + klopa - 1)].equals("WK")))
                            DangerFromUp = false;
                    }
                }



                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                // Έλεγχος αν υπάρχει κίνδυνος για το μαύρο βασιλιά ΑΠΟ ΚΑΤΩ (από πύργο ή βασίλισσα).
                ///////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromDown = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingRank - klopa) >= 1) && (DangerFromDown == true))
                    {
                        if ((BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("BQ")))
                            DangerFromDown = false;
                        else if ((BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn - 1)][(BlKingRank - klopa - 1)].equals("WK")))
                            DangerFromDown = false;
                    }
                }



                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Έλεγχος αν υπάρχει κίνδυνος για το μαύρο βασιλιά ΑΠΟ ΠΑΝΩ-ΔΕΞΙΑ ΤΟΥ (από βασίλισσα ή αξιωματικό).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromUpRight = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingColumn + klopa) <= 8) && ((BlKingRank + klopa) <= 8) && (DangerFromUpRight == true))
                    {
                        if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("BQ")))
                            DangerFromUpRight = false;
                        else if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank + klopa - 1)].equals("WK")))
                            DangerFromUpRight = false;
                    }
                }



                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Έλεγχος αν υπάρχει κίνδυνος για το μαύρο βασιλιά ΑΠΟ ΚΑΤΩ-ΑΡΙΣΤΕΡΑ ΤΟΥ (από βασίλισσα ή αξιωματικό).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromDownLeft = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingColumn - klopa) >= 1) && ((BlKingRank - klopa) >= 1) && (DangerFromDownLeft == true))
                    {
                        if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("BQ")))
                            DangerFromDownLeft = false;
                        else if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank - klopa - 1)].equals("WK")))
                            DangerFromDownLeft = false;
                    }
                }


                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Έλεγχος αν υπάρχει κίνδυνος για το μαύρο βασιλιά ΑΠΟ ΚΑΤΩ-ΔΕΞΙΑ ΤΟΥ (από βασίλισσα ή αξιωματικό).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromDownRight = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingColumn + klopa) <= 8) && ((BlKingRank - klopa) >= 1) && (DangerFromDownRight == true))
                    {
                        if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("BQ")))
                            DangerFromDownRight = false;
                        else if ((BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn + klopa - 1)][(BlKingRank - klopa - 1)].equals("WK")))
                            DangerFromDownRight = false;
                    }
                }



                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Έλεγχος αν υπάρχει κίνδυνος για το μαύρο βασιλιά ΑΠΟ ΠΑΝΩ-ΑΡΙΣΤΕΡΑ ΤΟΥ (από βασίλισσα ή αξιωματικό).
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                DangerFromUpLeft = true;

                for (klopa = 1; klopa <= 7; klopa++)
                {
                    if (((BlKingColumn - klopa) >= 1) && ((BlKingRank + klopa) <= 8) && (DangerFromUpLeft == true))
                    {
                        if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("WB")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("WQ")))
                            KingCheck = true;
                        else if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("BP")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("BR")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("BN")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("BB")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("BQ")))
                            DangerFromUpLeft = false;
                        else if ((BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("WP")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("White Rook")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("WN")) || (BCSkakiera[(BlKingColumn - klopa - 1)][(BlKingRank + klopa - 1)].equals("WK")))
                            DangerFromUpLeft = false;
                    }
                }


                //////////////////////////////////////////////////////////////////////////
                // Έλεγχος για το αν ο μαύρος βασιλιάς απειλείται από πιόνι.
                //////////////////////////////////////////////////////////////////////////

                if (((BlKingColumn + 1) <= 8) && ((BlKingRank - 1) >= 1))
                {
                    if (BCSkakiera[(BlKingColumn + 1 - 1)][(BlKingRank - 1 - 1)].equals("WP"))
                    {
                        KingCheck = true;
                    }
                }


                if (((BlKingColumn - 1) >= 1) && ((BlKingRank - 1) >= 1))
                {
                    if (BCSkakiera[(BlKingColumn - 1 - 1)][(BlKingRank - 1 - 1)].equals("WP"))
                    {
                        KingCheck = true;
                    }
                }


                ///////////////////////////////////////////////////////////////////////
                // Έλεγχος για το αν ο μαύρος βασιλιάς απειλείται από ίππο.
                ///////////////////////////////////////////////////////////////////////

                if (((BlKingColumn + 1) <= 8) && ((BlKingRank + 2) <= 8))
                    if (BCSkakiera[(BlKingColumn + 1 - 1)][(BlKingRank + 2 - 1)].equals("WN"))
                        KingCheck = true;

                if (((BlKingColumn + 2) <= 8) && ((BlKingRank - 1) >= 1))
                    if (BCSkakiera[(BlKingColumn + 2 - 1)][(BlKingRank - 1 - 1)].equals("WN"))
                        KingCheck = true;

                if (((BlKingColumn + 1) <= 8) && ((BlKingRank - 2) >= 1))
                    if (BCSkakiera[(BlKingColumn + 1 - 1)][(BlKingRank - 2 - 1)].equals("WN"))
                        KingCheck = true;

                if (((BlKingColumn - 1) >= 1) && ((BlKingRank - 2) >= 1))
                    if (BCSkakiera[(BlKingColumn - 1 - 1)][(BlKingRank - 2 - 1)].equals("WN"))
                        KingCheck = true;

                if (((BlKingColumn - 2) >= 1) && ((BlKingRank - 1) >= 1))
                    if (BCSkakiera[(BlKingColumn - 2 - 1)][(BlKingRank - 1 - 1)].equals("WN"))
                        KingCheck = true;

                if (((BlKingColumn - 2) >= 1) && ((BlKingRank + 1) <= 8))
                    if (BCSkakiera[(BlKingColumn - 2 - 1)][(BlKingRank + 1 - 1)].equals("WN"))
                        KingCheck = true;

                if (((BlKingColumn - 1) >= 1) && ((BlKingRank + 2) <= 8))
                    if (BCSkakiera[(BlKingColumn - 1 - 1)][(BlKingRank + 2 - 1)].equals("WN"))
                        KingCheck = true;

                if (((BlKingColumn + 2) <= 8) && ((BlKingRank + 1) <= 8))
                    if (BCSkakiera[(BlKingColumn + 2 - 1)][(BlKingRank + 1 - 1)].equals("WN"))
                        KingCheck = true;

    return KingCheck;
}

public static boolean CheckForBlackMate(String[][] BMSkakiera)
{
			// Check if the BK is under checkmate

			boolean Mate;
			//v0.990: Changed MovingPiece and ProsorinoKommati with the CBM variables
			String MovingPieceCBM;
			String ProsorinoKommatiCBM;

			/////////////////////////////////////////////////////////////////////////////////////////////////////////
			// Μεταβλητή που χρησιμεύει στον έλεγχο για το αν υπάρχει ματ (βλ. συναρτήσεις CheckForWhiteMate() και
			// CheckForBlMate()).
			// Αναλυτικότερα, το πρόγραμμα ελέγχει αν αρχικά υπάρχει σαχ και, αν υπάρχει, ελέγχει αν αυτό το
			// σαχ μπορεί να αποφευχθεί με τη μετακίνηση του υπό απειλή βασιλιά σε κάποιο γειτονικό τετράγωνο.
			// Η μεταβλητή καταγράφει το αν συνεχίζει να υπάρχει πιθανότητα να υπάρχει ματ στη σκακιέρα.
			/////////////////////////////////////////////////////////////////////////////////////////////////////////

			boolean DangerForMate;

			////////////////////////////////////////////////////////////
			// Έλεγχος του αν υπάρχει "ματ" στον μαύρο βασιλιά
			////////////////////////////////////////////////////////////

			Mate = false;
			DangerForMate = true; // Αρχικά, προφανώς υπάρχει πιθανότητα να υπάρχει ματ στη σκακιέρα.
									 // Αν, ωστόσο, κάποια στιγμή βρεθεί ότι αν ο βασιλιάς μπορεί να μετακινηθεί
									 // σε ένα διπλανό τετράγωνο και να πάψει να υφίσταται σαχ, τότε παύει να
									 // υπάρχει πιθανότητα να υπάρχει ματ (προφανώς) και η μεταβλητή παίρνει την
									 // τιμή false.


			//////////////////////////////////////////////////////////////
			// Εύρεση των αρχικών συντεταγμένων του βασιλιά
			//////////////////////////////////////////////////////////////

			for (i = 0; i <= 7; i++)
			{
				for (j = 0; j <= 7; j++)
				{

					if (BMSkakiera[(i)][(j)].equals("BK"))
					{
						StartingBlKingColumn = (i + 1);
						StartingBlKingRank = (j + 1);
					}

				}
			}


			//////////////////////////////////////////////////
			// Έλεγχος αν ο μαύρος βασιλιάς είναι ματ
			//////////////////////////////////////////////////


			if (m_WhichColorPlays.equals("Black"))
			{

				////////////////////////////////////////////////
				// Έλεγχος αν υπάρχει σαχ αυτή τη στιγμή
				////////////////////////////////////////////////

				BlackKingCheck = CheckForBlackCheck(BMSkakiera);

				if (BlackKingCheck == false) // Αν αυτή τη στιγμή δεν υφίσταται σαχ, τότε να μη συνεχιστεί ο έλεγχος
				{
					DangerForMate = false; // καθώς ΔΕΝ συνεχίζει να υφίσταται πιθανότητα να υπάρχει ματ.
				}

				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο μαύρος βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα πάνω
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingBlKingRank < 8)
				{
					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1 + 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingRank - 1 + 1) <= 7))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά προς τα πάνω και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.
						// Ο έλεγχος γίνεται μόνο αν στο τετράγωνο που μετακινείται προσωρινά ο βασιλιάς δεν υπάρχει άλλο κομμάτι
						// του ίδιου χρώματος που να τον εμποδίζει και αν, φυσικά, ο βασιλιάς δεν βγαίνει έξω από τη σκακιέρα με
						// αυτή του την κίνηση και αν, προφανώς, συνεχίζει να υπάρχει πιθανότητα να ύπάρχει ματ (καθώς αν δεν
						// υπάρχει τέτοια πιθανότητα, τότε ο έλεγχος είναι άχρηστος).

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1 + 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1 + 1)] = ProsorinoKommatiCBM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο μαύρος βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα πάνω-δεξιά
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingBlKingColumn < 8) && (StartingBlKingRank < 8))
				{

					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1 + 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingRank - 1 + 1) <= 7) && ((StartingBlKingColumn - 1 + 1) <= 7))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1 + 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1 + 1)] = ProsorinoKommatiCBM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο μαύρος βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα δεξιά
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingBlKingColumn < 8)
				{

					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingColumn - 1 + 1) <= 7))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1)] = ProsorinoKommatiCBM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο μαύρος βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα κάτω-δεξιά
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingBlKingColumn < 8) && (StartingBlKingRank > 1))
				{

					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1 - 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingRank - 1 - 1) >= 0) && ((StartingBlKingColumn - 1 + 1) <= 7))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1 - 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1 + 1)][(StartingBlKingRank - 1 - 1)] = ProsorinoKommatiCBM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο μαύρος βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα κάτω
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingBlKingRank > 1)
				{

					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1 - 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingRank - 1 - 1) >= 0))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά προς τα πάνω και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1 - 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1 - 1)] = ProsorinoKommatiCBM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο μαύρος βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα κάτω-αριστερά
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingBlKingColumn > 1) && (StartingBlKingRank > 1))
				{

					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1 - 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingRank - 1 - 1) >= 0) && ((StartingBlKingColumn - 1 - 1) >= 0))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1 - 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1 - 1)] = ProsorinoKommatiCBM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο μαύρος βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα αριστερά
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingBlKingColumn > 1)
				{

					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingColumn - 1 - 1) >= 0))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1)] = ProsorinoKommatiCBM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο μαύρος βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα πάνω-αριστερά
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingBlKingColumn > 1) && (StartingBlKingRank < 8))
				{

					MovingPieceCBM = BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)];
					ProsorinoKommatiCBM = BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1 + 1)];

					if ((ProsorinoKommatiCBM.compareTo("BQ") == 1) && (ProsorinoKommatiCBM.compareTo("BR") == 1) && (ProsorinoKommatiCBM.compareTo("BN") == 1) && (ProsorinoKommatiCBM.compareTo("BB") == 1) && (ProsorinoKommatiCBM.compareTo("BP") == 1) && (DangerForMate == true) && ((StartingBlKingRank - 1 + 1) <= 7) && ((StartingBlKingColumn - 1 - 1) >= 0))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = "";
						BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1 + 1)] = MovingPieceCBM;
						BlackKingCheck = CheckForBlackCheck(BMSkakiera);

						if (BlackKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						BMSkakiera[(StartingBlKingColumn - 1)][(StartingBlKingRank - 1)] = MovingPieceCBM;
						BMSkakiera[(StartingBlKingColumn - 1 - 1)][(StartingBlKingRank - 1 + 1)] = ProsorinoKommatiCBM;

					}

				}

				if (DangerForMate == true)
				{
					Mate = true;
				}

			}

			return Mate;
		}

public static boolean CheckForWhiteMate(String[][] WMSkakiera)
{
			// Check if the WK is under checkmate

			boolean Mate;
			//v0.990: Changed MovingPiece and ProsorinoKommati with the CWM variables
			String MovingPieceCWM;
			String ProsorinoKommatiCWM;

			/////////////////////////////////////////////////////////////////////////////////////////////////////////
			// Μεταβλητή που χρησιμεύει στον έλεγχο για το αν υπάρχει ματ (βλ. συναρτήσεις CheckForWhiteMate() και
			// CheckForBlMate()).
			// Αναλυτικότερα, το πρόγραμμα ελέγχει αν αρχικά υπάρχει σαχ και, αν υπάρχει, ελέγχει αν αυτό το
			// σαχ μπορεί να αποφευχθεί με τη μετακίνηση του υπό απειλή βασιλιά σε κάποιο γειτονικό τετράγωνο.
			// Η μεταβλητή καταγράφει το αν συνεχίζει να υπάρχει πιθανότητα να υπάρχει ματ στη σκακιέρα.
			/////////////////////////////////////////////////////////////////////////////////////////////////////////

			boolean DangerForMate;

			////////////////////////////////////////////////////////////
			// Έλεγχος του αν υπάρχει "ματ" στον λευκό βασιλιά
			////////////////////////////////////////////////////////////

			Mate = false;
			DangerForMate = true; // Αρχικά, προφανώς υπάρχει πιθανότητα να υπάρχει ματ στη σκακιέρα.
									 // Αν, ωστόσο, κάποια στιγμή βρεθεί ότι αν ο βασιλιάς μπορεί να μετακινηθεί
									 // σε ένα διπλανό τετράγωνο και να πάψει να υφίσταται σαχ, τότε παύει να
									 // υπάρχει πιθανότητα να υπάρχει ματ (προφανώς) και η μεταβλητή παίρνει την
									 // τιμή false.


			//////////////////////////////////////////////////////////////
			// Εύρεση των αρχικών συντεταγμένων του βασιλιά
			//////////////////////////////////////////////////////////////

			for (i = 0; i <= 7; i++)
			{
				for (j = 0; j <= 7; j++)
				{

					if (WMSkakiera[(i)][(j)].equals("WK"))
					{
						StartingWhiteKingColumn = (i + 1);
						StartingWhiteKingRank = (j + 1);
					}

				}
			}


			//////////////////////////////////////////////////
			// Έλεγχος αν ο λευκός βασιλιάς είναι ματ
			//////////////////////////////////////////////////


			if (m_WhichColorPlays.equals("White"))
			{

				////////////////////////////////////////////////
				// Έλεγχος αν υπάρχει σαχ αυτή τη στιγμή
				////////////////////////////////////////////////

				WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

				if (WhiteKingCheck == false) // Αν αυτή τη στιγμή δεν υφίσταται σαχ, τότε να μη συνεχιστεί ο έλεγχος
				{
					DangerForMate = false; // καθώς ΔΕΝ συνεχίζει να υφίσταται πιθανότητα να υπάρχει ματ.
				}

				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο λευκός βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα πάνω
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingWhiteKingRank < 8)
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1 + 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingRank - 1 + 1) <= 7))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά προς τα πάνω και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.
						// Ο έλεγχος γίνεται μόνο αν στο τετράγωνο που μετακινείται προσωρινά ο βασιλιάς δεν υπάρχει άλλο κομμάτι
						// του ίδιου χρώματος που να τον εμποδίζει και αν, φυσικά, ο βασιλιάς δεν βγαίνει έξω από τη σκακιέρα με
						// αυτή του την κίνηση και αν, προφανώς, συνεχίζει να υπάρχει πιθανότητα να ύπάρχει ματ (καθώς αν δεν
						// υπάρχει τέτοια πιθανότητα, τότε ο έλεγχος είναι άχρηστος).

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1 + 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1 + 1)] = ProsorinoKommatiCWM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο λευκός βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα πάνω-δεξιά
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingWhiteKingColumn < 8) && (StartingWhiteKingRank < 8))
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1 + 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingRank - 1 + 1) <= 7) && ((StartingWhiteKingColumn - 1 + 1) <= 7))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1 + 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1 + 1)] = ProsorinoKommatiCWM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο λευκός βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα δεξιά
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingWhiteKingColumn < 8)
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingColumn - 1 + 1) <= 7))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1)] = ProsorinoKommatiCWM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο λευκός βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα κάτω-δεξιά
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingWhiteKingColumn < 8) && (StartingWhiteKingRank > 1))
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1 - 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingRank - 1 - 1) >= 0) && ((StartingWhiteKingColumn - 1 + 1) <= 7))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1 - 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1 + 1)][(StartingWhiteKingRank - 1 - 1)] = ProsorinoKommatiCWM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο λευκός βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα κάτω
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingWhiteKingRank > 1)
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1 - 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingRank - 1 - 1) >= 0))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά προς τα πάνω και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1 - 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1 - 1)] = ProsorinoKommatiCWM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο λευκός βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα κάτω-αριστερά
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingWhiteKingColumn > 1) && (StartingWhiteKingRank > 1))
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1 - 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingRank - 1 - 1) >= 0) && ((StartingWhiteKingColumn - 1 - 1) >= 0))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1 - 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1 - 1)] = ProsorinoKommatiCWM;

					}
				}

				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο λευκός βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα αριστερά
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (StartingWhiteKingColumn > 1)
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingColumn - 1 - 1) >= 0))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1)] = ProsorinoKommatiCWM;

					}

				}


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Έλεγχος του αν θα συνεχίσει να υπάρχει σαχ αν ο λευκός βασιλιάς προσπαθήσει να διαφύγει μετακινούμενος
				// προς τα πάνω-αριστερά
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////

				if ((StartingWhiteKingColumn > 1) && (StartingWhiteKingRank < 8))
				{

					MovingPieceCWM = WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)];
					ProsorinoKommatiCWM = WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1 + 1)];

					if ((ProsorinoKommatiCWM.compareTo("WQ") == 1) && (ProsorinoKommatiCWM.compareTo("White Rook") == 1) && (ProsorinoKommatiCWM.compareTo("WN") == 1) && (ProsorinoKommatiCWM.compareTo("WB") == 1) && (ProsorinoKommatiCWM.compareTo("WP") == 1) && (DangerForMate == true) && ((StartingWhiteKingRank - 1 + 1) <= 7) && ((StartingWhiteKingColumn - 1 - 1) >= 0))
					{

						// (Προσωρινή) μετακίνηση του βασιλιά και έλεγχος του αν συνεχίζει τότε να υπάρχει σαχ.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = "";
						WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1 + 1)] = MovingPieceCWM;
						WhiteKingCheck = CheckForWhiteCheck(WMSkakiera);

						if (WhiteKingCheck == false)
						{
							DangerForMate = false;
						}

						// Επαναφορά της σκακιέρας στην κατάσταση στην οποία βρισκόταν πριν μετακινηθεί ο βασιλιάς για τους
						// σκοπούς του ελέγχου.

						WMSkakiera[(StartingWhiteKingColumn - 1)][(StartingWhiteKingRank - 1)] = MovingPieceCWM;
						WMSkakiera[(StartingWhiteKingColumn - 1 - 1)][(StartingWhiteKingRank - 1 + 1)] = ProsorinoKommatiCWM;

					}

				}

				if (DangerForMate == true)
				{
					Mate = true;
				}

			}

			return Mate;
		}

public static void Analyze_Move_1_HumanMove(String[][] Skakiera_Human_Thinking_2)
{
    // v0.990 change: The best score for every move will be stored at each level. Only if the new move analyzed
    // has a better score than the best score, will it be analyzed (target: trim the analysis tree)
    double bestScoreLevel1 = 0;

    // Scan chessboard . Find a piece of the Hu player . Move to all possible squares.
    // Check corr1ectness and legality of move . If all OK then measure the move's score.
    // Do the best move and handle over to the ComputerMove function to continue analysis in the next move (deeper depth...)
    //v0.990: Initialized the values
    int skakos1 = 0;
    int trelos35 = 0;
    String MovingPiece1 = "";
    String ProsorinoKommati1 = "";
    int m_StartingColumnNumber1 = 0;
    int m_FinishingColumnNumber1 = 0;
    int m_StartingRank1 = 0;
    int m_FinishingRank1 = 0;

    //v0.990
    String[][] Skakiera_Move_After_1 = new String[8][8];

    // Check all possible moves
    for (skakos1 = 0; skakos1 <= 7; skakos1++)
    {
        for (trelos35 = 0; trelos35 <= 7; trelos35++)
        {
            //v0.990: (Who_Is_Analyzed.equals("Hu")) -> (Who_Is_Analyzed.equals("Human"))
            if (((Who_Is_Analyzed.equals("Human")) && ((((Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("BK")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("BQ")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("BR")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("BN")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("BB")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("BP"))) && (m_PlayerColor.equals("b"))) || (((Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("WK")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("WQ")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("White Rook")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("WN")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("WB")) || (Skakiera_Human_Thinking_2[(skakos1)][(trelos35)].equals("WP"))) && (m_PlayerColor.equals("w"))))))
            {
                for (int w = 0; w <= 7; w++)
                {
                    for (int r = 0; r <= 7; r++)
                    {
                        //v0.990: Removed the m_FinishingRank column and replace with m_FinishingRank1
                        MovingPiece1 = Skakiera_Human_Thinking_2[(skakos1)][(trelos35)];
                        m_StartingColumnNumber1 = skakos1 + 1;
                        m_FinishingColumnNumber1 = w + 1;
                        m_StartingRank1 = trelos35 + 1;
                        m_FinishingRank1 = r + 1;

                        // Store temporary move data in local variables, so as to use them in the Undo of the move
                        // at the end of this function (the MovingPiece, m_StartingColumnNumber, etc variables are
                        // changed by next functions as well, so using them leads to problems)
                        //v0.990: Removed the m_FinishingRank column and replace with m_FinishingRank1
                        //MovingPiece1 = MovingPiece;
                        //m_StartingColumnNumber1 = m_StartingColumnNumber;
                        //m_FinishingColumnNumber1 = m_FinishingColumnNumber;
                        //m_StartingRank1 = m_StartingRank;
                        //m_FinishingRank1 = m_FinishingRank;
                        ProsorinoKommati1 = Skakiera_Human_Thinking_2[(m_FinishingColumnNumber1 - 1)][(m_FinishingRank1 - 1)];

                        // Check the move
                        //v0.980: Removed
                        number_of_moves_analysed++;

                        // Necessary values for variables for the ElegxosOrthotitas (check move corr1ectness) and
                        // ElegxosNomimotitas (check move legality) function to...function properly.
                        m_WhoPlays = "Human";
                        m_WrongColumn = false;
                        //v0.990
                        //MovingPiece1 = Skakiera_Human_Thinking_2[(m_StartingColumnNumber1 - 1), (m_StartingRank1 - 1)];
                        //v0.990: MovingPiece -> MovingPiece1
                        m_OrthotitaKinisis = ElegxosOrthotitas(Skakiera_Human_Thinking_2, 0, m_StartingRank1, m_StartingColumnNumber1, m_FinishingRank1, m_FinishingColumnNumber1, MovingPiece1);
                        m_NomimotitaKinisis = ElegxosNomimotitas(Skakiera_Human_Thinking_2, 0, m_StartingRank1, m_StartingColumnNumber1, m_FinishingRank1, m_FinishingColumnNumber1, MovingPiece1);
                        // Restore normal value of m_WhoPlays
                        m_WhoPlays = "HY";

                        // If all ok, then do the move and measure it
                        if ((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true))
                        {
                            // Do the move
                            //v0.990: ProsorinoKommati -> ProsorinoKommati1, MovingPiece -> MovingPiece1
                            ProsorinoKommati1 = Skakiera_Human_Thinking_2[(m_FinishingColumnNumber1 - 1)][(m_FinishingRank1 - 1)];
                            Skakiera_Human_Thinking_2[(m_StartingColumnNumber1 - 1)][(m_StartingRank1 - 1)] = "";
                            Skakiera_Human_Thinking_2[(m_FinishingColumnNumber1 - 1)][(m_FinishingRank1 - 1)] = MovingPiece1;

                            // Measure score AFTER the move
                            Temp_Score_Move_1_human = CountScore(Skakiera_Human_Thinking_2);

                            // v0.992: Score and parent for each move analyzed are stored on the spot and not at the end of the thinking depth
                            // since some branches of the thinking tree might be trimmed, thus not available at the end of the thinking depth for
                            // their score and parent to be stored!
                            // Store scores
                            //NodesAnalysis0[NodeLevel_0_count, 0] = Temp_Score_Move_0;
                            NodesAnalysis1[NodeLevel_1_count][0] = Temp_Score_Move_1_human;
                            //NodesAnalysis2[NodeLevel_2_count, 0] = Temp_Score_Move_2;
                            //NodesAnalysis3[NodeLevel_3_count, 0] = Temp_Score_Move_3_human;
                            //NodesAnalysis4[NodeLevel_4_count, 0] = Temp_Score_Move_4;
                            // Store parents
                            //NodesAnalysis0[NodeLevel_0_count, 1] = 0;
                            NodesAnalysis1[NodeLevel_1_count][1] = NodeLevel_0_count;
                                        
                            // Store the best move at this level
                            if ((m_PlayerColor.equals("b")) && (Temp_Score_Move_1_human < bestScoreLevel1))
                            {
                                bestScoreLevel1 = Temp_Score_Move_1_human;
                            }
                            else if ((m_PlayerColor.equals("w")) && (Temp_Score_Move_1_human > bestScoreLevel1))
                            {
                                bestScoreLevel1 = Temp_Score_Move_1_human;
                            }

                            if (Move_Analyzed < Thinking_Depth)
                            // v0.990 test
                            //if ( ((Move_Analyzed < Thinking_Depth) && (m_PlayerColor.equals("w")) && (Temp_Score_Move_1_human >= bestScoreLevel1))
                            //  || ((Move_Analyzed < Thinking_Depth) && (m_PlayerColor.equals("b")) && (Temp_Score_Move_1_human <= bestScoreLevel1)) )
                            {
                                    // Call ComputerMove for the HY throught process to continue
                                    Move_Analyzed = Move_Analyzed + 1;

                                    Who_Is_Analyzed = "HY";

                                    //v0.990
                                    String[][] Skakiera_Move_After_1_new = new String[8][8];

                                    //v0.990: Why copy everything in Skakiera_Move_After?
                                    //Just use Skakiera_Human_Thinking_2 directly! No!
                                    //Remember the problem with the "reference" of the array at with ElegxosNomimotitas!)
                                    //Arrays can be passed as arguments to method parameters. Because arrays are reference types, the method can change the value of the elements.
                                    //SOURCES...
                                    //https://docs.microsoft.com/en-us/dotnet/articles/csharp/programming-guide/arrays/passing-arrays-as-arguments]
                                    //http://stackoverflow.com/questions/10325323/passing-arrays-by-value-and-by-reference
                                    //http://stackoverflow.com/questions/967402/are-arrays-or-lists-passed-by-default-by-reference-in-c
                                    for (i = 0; i <= 7; i++)
                                    {
                                        for (j = 0; j <= 7; j++)
                                        {
                                            Skakiera_Move_After_1[(i)][(j)] = Skakiera_Human_Thinking_2[(i)][(j)];
                                            Skakiera_Move_After_1_new[(i)][(j)] = Skakiera_Human_Thinking_2[(i)][(j)];
                                        }
                                    }

                                    //v0.990: Skakiera_Move_After -> Skakiera_Move_After_1 -> Skakiera_Move_After_1_new
                                    if (Move_Analyzed == 2)
                                    {
                                        Analyze_Move_2_ComputerMove(Skakiera_Move_After_1_new);
                                    }
                            }

                            // Undo the move
                            Skakiera_Human_Thinking_2[(m_StartingColumnNumber1 - 1)][(m_StartingRank1 - 1)] = MovingPiece1;
                            Skakiera_Human_Thinking_2[(m_FinishingColumnNumber1 - 1)][(m_FinishingRank1 - 1)] = ProsorinoKommati1;

                            //v0.991
                            NodeLevel_1_count++;
                         }

                    } // For 4
                } // For 3

            } // IF

        } // For 2
    } // For 1

    //v0.992 suggestion: Check if there is mate or stalemate!
    if (Human_Move_Found == false)
    {
        // Check for check
        if (m_PlayerColor.equals("w"))
        {
            WhiteKingCheck = CheckForWhiteCheck(Skakiera_Human_Thinking_2);
        }
        else if (m_PlayerColor.equals("b"))
        {
            BlackKingCheck = CheckForBlackCheck(Skakiera_Human_Thinking_2);
        }
        // If no move found and it is check, then it is mate! Go for it!
        if ((m_PlayerColor.equals("w")) && (WhiteKingCheck == true))
        {
            Mate_Found = true;
            m_StartingColumnNumber_mate = m_StartingColumnNumber_HY;
            m_FinishingColumnNumber_mate = m_FinishingColumnNumber_HY;
            m_StartingRank_mate = m_StartingRank_HY;
            m_FinishingRank_mate = m_FinishingRank_HY;
        }
        // If there is no move and the king is not under check, it is pat! (stalemate)
        if ((m_PlayerColor.equals("w")) && (WhiteKingCheck == false))
        {
            Pat_Found = true;
        }
        if ((m_PlayerColor.equals("b")) && (BlackKingCheck == true))
        {
            Mate_Found = true;
            m_StartingColumnNumber_mate = m_StartingColumnNumber_HY;
            m_FinishingColumnNumber_mate = m_FinishingColumnNumber_HY;
            m_StartingRank_mate = m_StartingRank_HY;
            m_FinishingRank_mate = m_FinishingRank_HY;
        }
        // If there is no move and the king is not under check, it is pat! (stalemate)
        if ((m_PlayerColor.equals("b")) && (BlackKingCheck == false))
        {
            //Pat! (= stalemate)
            Pat_Found = true;
        }
    }
                
    Move_Analyzed = Move_Analyzed - 1;
    Who_Is_Analyzed = "HY";
}

public static void Analyze_Move_2_ComputerMove(String[][] Skakiera_Thinking_HY_2)
{
    // v0.990 change: The best score for every move will be stored at each level. Only if the new move analyzed
    // has a better score than the best score, will it be analyzed (target: trim the analysis tree)
    //double bestScoreLevel2 = 0;

    // Δήλωση μεταβλητών που χρησιμοποιούνται στο βρόγχο "for" (δεν μπορεί να χρησιμοποιηθούν οι μεταβλητές i και j διότι αυτές οι
    // μεταβλητές είναι καθολικές και δημιουργείται πρόβλημα κατά την επιστροφή στην ComputerMove από την CheckMove)
    //v0.990: Initialized the values
    int iii2 = 0;
    int jjj2 = 0;
    String MovingPiece2 = "";
    String ProsorinoKommati2 = "";
    int m_StartingColumnNumber2 = 0;
    int m_FinishingColumnNumber2 = 0;
    int m_StartingRank2 = 0;
    int m_FinishingRank2 = 0;

    //v0.990
    String[][] Skakiera_Move_After_2 = new String[8][8];

    //huo_sw1.WriteLine(String.Concat("[Point 0] -> Σκακιέρα[5,1] = ", Skakiera_Thinking_HY_2[4, 0].ToString()));

    // Σκανάρισμα της σκακιέρας: Όταν εντοπίζεται κάποιο κομμάτι του υπολογιστή,
    // θα υπολογίζονται ΟΛΕΣ οι πιθανές κινήσεις του προς κάθε κατεύθυνση, ακόμα
    // και αυτές που δεν μπορεί να κάνει το κομμάτι. Στη συνέχεια, με τη βοήθεια
    // των συναρτήσεων ElegxosNomimotitas και ElegxosOrthotitas θα ελέγχεται το
    // αν η κίνηση είναι ορθή και νόμιμη. Αν είναι, η εν λόγω κίνηση θα γίνεται
    // προσωρινά στη σκακιέρα και θα καταγράφεται το σκορ της νέας θέσης που
    // προέκυψε

    // ΣΗΜΕΙΩΣΗ: Σε όλες τις στήλες και τις οριζόντιους προστίθεται η μονάδα (+1)
    // διότι πρέπει να μετατραπούν από το "σύστημα" μέτρησης "0-7" (που χρησιμο-
    // ποιείται στο παρακάτω "for i…next" αλλά και στο συμβολισμό του πίνακα
    // Skakiera) στο σύστημα μέτρησης "1-8" το οποίο χρησιμοποιείται στις
    // μεταβλητές Starting/Finishing_Column/Rank σε όλο το υπόλοιπο πρόγραμμα.

    for (iii2 = 0; iii2 <= 7; iii2++)
    {
        for (jjj2 = 0; jjj2 <= 7; jjj2++)
        {
            if (((Who_Is_Analyzed.equals("HY")) && ((((Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("WK")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("WQ")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("White Rook")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("WN")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("WB")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("WP"))) && (m_PlayerColor.equals("b"))) || (((Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("BK")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("BQ")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("BR")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("BN")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("BB")) || (Skakiera_Thinking_HY_2[(iii2)][(jjj2)].equals("BP"))) && (m_PlayerColor.equals("w"))))))
            {
                //huo_sw1.WriteLine(String.Concat("[Point 1] -> Σκακιέρα[5,1] = ", Skakiera_Thinking_HY_2[4, 0].ToString()));

                for (int w = 0; w <= 7; w++)
                {
                    for (int r = 0; r <= 7; r++)
                    {
                        //huo_sw1.WriteLine(String.Concat("[Point 2] -> Σκακιέρα[5,1] = ", Skakiera_Thinking_HY_2[4, 0].ToString()));

                        //v0.990: Replaced m_StartingColumnNumber with m_StartingColumnNumber2
                        MovingPiece2 = Skakiera_Thinking_HY_2[(iii2)][(jjj2)];
                        m_StartingColumnNumber2 = iii2 + 1;
                        m_FinishingColumnNumber2 = w + 1;
                        m_StartingRank2 = jjj2 + 1;
                        m_FinishingRank2 = r + 1;
                        ProsorinoKommati2 = Skakiera_Thinking_HY_2[(m_FinishingColumnNumber2 - 1)][(m_FinishingRank2 - 1)];

                        // Έλεγχος της κίνησης

                        // Validity and legality of the move has been checked in CheckMove
                        // CheckMove(Skakiera_Thinking_HY_2);

                        // Check validity and legality
                        // Necessary values for variables for the ElegxosOrthotitas (check move corr1ectness) and
                        // ElegxosNomimotitas (check move legality) function to...function properly.
                        m_WhoPlays = "Human";
                        m_WrongColumn = false;
                        //v0.990: MovingPiece -> MovingPiece2

                        m_OrthotitaKinisis = ElegxosOrthotitas(Skakiera_Thinking_HY_2, 0, m_StartingRank2, m_StartingColumnNumber2, m_FinishingRank2, m_FinishingColumnNumber2, MovingPiece2);
                        m_NomimotitaKinisis = ElegxosNomimotitas(Skakiera_Thinking_HY_2, 0, m_StartingRank2, m_StartingColumnNumber2, m_FinishingRank2, m_FinishingColumnNumber2, MovingPiece2);
                        // Restore normal value of m_WhoPlays
                        m_WhoPlays = "HY";

                        // If all ok, then do the move and measure it
                        if ((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true))
                        {
                            //huo_sw1.WriteLine(string.Concat("Hu move 1: Found a legal move!"));
                            //huo_sw1.WriteLine(String.Concat("[Point 5] -> Σκακιέρα[5,1] = ", Skakiera_Thinking_HY_2[4, 0].ToString()));

                            // Do the move
                            //v0.990: ProsorinoKommati -> ProsorinoKommati2, MovingPiece -> MovingPiece2
                            ProsorinoKommati2 = Skakiera_Thinking_HY_2[(m_FinishingColumnNumber2 - 1)][(m_FinishingRank2 - 1)];
                            Skakiera_Thinking_HY_2[(m_StartingColumnNumber2 - 1)][(m_StartingRank2 - 1)] = "";
                            Skakiera_Thinking_HY_2[(m_FinishingColumnNumber2 - 1)][(m_FinishingRank2 - 1)] = MovingPiece2;

                            //v0.991
                            //NodeLevel_2_count++;
                            //v0.980: Removed humanDangerParameter from every call of countScore
                            Temp_Score_Move_2 = CountScore(Skakiera_Thinking_HY_2);

                            // v0.992: Score and parent for each move analyzed are stored on the spot and not at the end of the thinking depth
                            // since some branches of the thinking tree might be trimmed, thus not available at the end of the thinking depth for
                            // their score and parent to be stored!
                            // Store scores
                            NodesAnalysis2[NodeLevel_2_count][0] = Temp_Score_Move_2;
                            // Store parents
                            NodesAnalysis2[NodeLevel_2_count][1] = NodeLevel_1_count;
                                        
                            // v0.990 change
                            // Store the best score at this level
                            //if ((m_PlayerColor.equals("b")) && (Temp_Score_Move_2 > bestScoreLevel2))
                            //{
                            //        bestScoreLevel2 = Temp_Score_Move_2;
                            //}
                            //else if ((m_PlayerColor.equals("w")) && (Temp_Score_Move_2 < bestScoreLevel2))
                            //{
                            //        bestScoreLevel2 = Temp_Score_Move_2;
                            //}

                            // v0.990 change: Added back the part which calls deeper levels of analysis
                            // v0.990 change: Must trim the tree or else the app does not work and consums a lot of memory!
                            // Think deeper only if there is a piece capture
                            //if (Move_Analyzed < Thinking_Depth)
                            // v0.990 Move 4 changes: Trim the tree!
                            //if (((Move_Analyzed < Thinking_Depth) && (m_PlayerColor.equals("w")) && (Temp_Score_Move_2 <= bestScoreLevel2)) || ((Move_Analyzed < Thinking_Depth) && (m_PlayerColor.equals("b")) && (Temp_Score_Move_2 >= bestScoreLevel2)))
                            if ((Move_Analyzed < Thinking_Depth) && (!"".equals(ProsorinoKommati2)))    
                            {
                                Move_Analyzed = Move_Analyzed + 1;

                                //v0.990: Skakiera_Move_After -> Skakiera_Move_After_2
                                for (i = 0; i <= 7; i++)
                                {
                                    for (j = 0; j <= 7; j++)
                                    {
                                        Skakiera_Move_After_2[(i)][(j)] = Skakiera_Thinking_HY_2[(i)][(j)];
                                    }
                                }

                                Who_Is_Analyzed = "Human";
                                //V0.980 REMOVED First_Call_Human_Thought = true;

                                // v0.990 Move 4 changes
                                // Check human move
                                //v0.990: Skakiera_Move_After -> Skakiera_Thinking_HY_2
                                if (Move_Analyzed == 3)
                                {
                                    Analyze_Move_3_HumanMove(Skakiera_Move_After_2);
                                }
                            }

//                            if (Move_Analyzed == Thinking_Depth)
//                            {
//                                // [MiniMax algorithm - skakos]
//                                // Record the node in the Nodes Analysis array (to use with MiniMax algorithm) skakos
//
//                                //v0.970
//                                NodesAnalysis0[NodeLevel_0_count][0] = Temp_Score_Move_0;
//                                NodesAnalysis1[NodeLevel_1_count][0] = Temp_Score_Move_1_human;
//                                NodesAnalysis2[NodeLevel_2_count][0] = Temp_Score_Move_2;
//
//                                // Store the parents (number of the node of the upper level)
//                                NodesAnalysis0[NodeLevel_0_count][1] = 0;
//                                NodesAnalysis1[NodeLevel_1_count][1] = NodeLevel_0_count;
//                                NodesAnalysis2[NodeLevel_2_count][1] = NodeLevel_1_count;
//
//                                ///#endregion toRemove
//
//                                //v0.980: removed
//                                Nodes_Total_count++;
//                            }

                            // Undo the move
                            Skakiera_Thinking_HY_2[(m_StartingColumnNumber2 - 1)][(m_StartingRank2 - 1)] = MovingPiece2;
                            Skakiera_Thinking_HY_2[(m_FinishingColumnNumber2 - 1)][(m_FinishingRank2 - 1)] = ProsorinoKommati2;

                            //v0.991
                            NodeLevel_2_count++;
                        }

                    } // FOR 4
                } // FOR 3

            } // IF
        }
    }

    Move_Analyzed = Move_Analyzed - 1;
    Who_Is_Analyzed = "Human";
}

public static void Analyze_Move_3_HumanMove(String[][] Skakiera_Human_Thinking_3)
{
    // v0.990 change: The best score for every move will be stored at each level. Only if the new move analyzed
    // has a better score than the best score, will it be analyzed (target: trim the analysis tree)
    //double bestScoreLevel3 = 0;

    // Scan chessboard . Find a piece of the Hu player . Move to all possible squares.
    // Check corr1ectness and legality of move . If all OK then measure the move's score.
    // Do the best move and handle over to the ComputerMove function to continue analysis in the next move (deeper depth...)
    //v0.990: Initialized the values
    int skakos3 = 0;
    int trelos36 = 0;
    String MovingPiece3 = "";
    String ProsorinoKommati3 = "";
    int m_StartingColumnNumber3 = 0;
    int m_FinishingColumnNumber3 = 0;
    int m_StartingRank3 = 0;
    int m_FinishingRank3 = 0;

    //v0.990
    String[][] Skakiera_Move_After_3 = new String[8][8];

    // Check all possible moves
    for (skakos3 = 0; skakos3 <= 7; skakos3++)
    {
        for (trelos36 = 0; trelos36 <= 7; trelos36++)
        {
            //v0.990: (Who_Is_Analyzed.equals("Hu")) -> (Who_Is_Analyzed.equals("Human"))
            if (((Who_Is_Analyzed.equals("Human")) && ((((Skakiera_Human_Thinking_3[(skakos3)][(trelos36)].equals("BK")) || (Skakiera_Human_Thinking_3[(skakos3)][(trelos36)].equals("BQ")) || (Skakiera_Human_Thinking_3[(skakos3)][(trelos36)].equals("BR")) || (Skakiera_Human_Thinking_3[(skakos3)][(trelos36)].equals("BN")) || (Skakiera_Human_Thinking_3[(skakos3)][(trelos36)].equals("BB")) || (Skakiera_Human_Thinking_3[(skakos3)][(trelos36)].equals("BP"))) && (m_PlayerColor.equals("b"))) || (((Skakiera_Human_Thinking_3[(skakos3)][(trelos36)].equals("WK")) || (Skakiera_Human_Thinking_3[(skakos3)][(trelos36)].equals("WQ")) || (Skakiera_Human_Thinking_3[(skakos3)][(trelos36)].equals("White Rook")) || (Skakiera_Human_Thinking_3[(skakos3)][(trelos36)].equals("WN")) || (Skakiera_Human_Thinking_3[(skakos3)][(trelos36)].equals("WB")) || (Skakiera_Human_Thinking_3[(skakos3)][(trelos36)].equals("WP"))) && (m_PlayerColor.equals("w"))))))
            {
                for (int w = 0; w <= 7; w++)
                {
                    for (int r = 0; r <= 7; r++)
                    {
                        //v0.990: Removed the m_FinishingRank column and replace with m_FinishingRank3
                        MovingPiece3 = Skakiera_Human_Thinking_3[(skakos3)][(trelos36)];
                        m_StartingColumnNumber3 = skakos3 + 1;
                        m_FinishingColumnNumber3 = w + 1;
                        m_StartingRank3 = trelos36 + 1;
                        m_FinishingRank3 = r + 1;

                        // Store temporary move data in local variables, so as to use them in the Undo of the move
                        // at the end of this function (the MovingPiece, m_StartingColumnNumber, etc variables are
                        // changed by next functions as well, so using them leads to problems)
                        //v0.990: Removed the m_FinishingRank column and replace with m_FinishingRank3
                        //MovingPiece3 = MovingPiece;
                        //m_StartingColumnNumber3 = m_StartingColumnNumber;
                        //m_FinishingColumnNumber3 = m_FinishingColumnNumber;
                        //m_StartingRank3 = m_StartingRank;
                        //m_FinishingRank3 = m_FinishingRank;
                        ProsorinoKommati3 = Skakiera_Human_Thinking_3[(m_FinishingColumnNumber3 - 1)][(m_FinishingRank3 - 1)];

                        // Check the move
                        //v0.980: Removed
                        number_of_moves_analysed++;

                        // Necessary values for variables for the ElegxosOrthotitas (check move corr1ectness) and
                        // ElegxosNomimotitas (check move legality) function to...function properly.
                        m_WhoPlays = "Human";
                        m_WrongColumn = false;
                        //v0.990
                        //MovingPiece3 = Skakiera_Human_Thinking_3[(m_StartingColumnNumber3 - 1), (m_StartingRank3 - 1)];
                        //v0.990: MovingPiece -> MovingPiece3
                        m_OrthotitaKinisis = ElegxosOrthotitas(Skakiera_Human_Thinking_3, 0, m_StartingRank3, m_StartingColumnNumber3, m_FinishingRank3, m_FinishingColumnNumber3, MovingPiece3);
                        m_NomimotitaKinisis = ElegxosNomimotitas(Skakiera_Human_Thinking_3, 0, m_StartingRank3, m_StartingColumnNumber3, m_FinishingRank3, m_FinishingColumnNumber3, MovingPiece3);
                        // Restore normal value of m_WhoPlays
                        m_WhoPlays = "HY";

                        // If all ok, then do the move and measure it
                        if ((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true))
                        {
                            // Do the move
                            //v0.990: ProsorinoKommati -> ProsorinoKommati3, MovingPiece -> MovingPiece3
                            ProsorinoKommati3 = Skakiera_Human_Thinking_3[(m_FinishingColumnNumber3 - 1)][(m_FinishingRank3 - 1)];
                            Skakiera_Human_Thinking_3[(m_StartingColumnNumber3 - 1)][(m_StartingRank3 - 1)] = "";
                            Skakiera_Human_Thinking_3[(m_FinishingColumnNumber3 - 1)][(m_FinishingRank3 - 1)] = MovingPiece3;

                            // Measure score AFTER the move
                            Temp_Score_Move_3_human = CountScore(Skakiera_Human_Thinking_3);
                            
                            // v0.992: Score and parent for each move analyzed are stored on the spot and not at the end of the thinking depth
                            // since some branches of the thinking tree might be trimmed, thus not available at the end of the thinking depth for
                            // their score and parent to be stored!
                            // Store scores
                            NodesAnalysis3[NodeLevel_3_count][0] = Temp_Score_Move_3_human;
                            // Store parents
                            NodesAnalysis3[NodeLevel_3_count][1] = NodeLevel_2_count;

                            // Store the best move at this level
                            //if ((m_PlayerColor.equals("b")) && (Temp_Score_Move_3_human < bestScoreLevel3))
                            //{
                            //    bestScoreLevel3 = Temp_Score_Move_3_human;
                            //}
                            //else if ((m_PlayerColor.equals("w")) && (Temp_Score_Move_3_human > bestScoreLevel3))
                            //{
                            //    bestScoreLevel3 = Temp_Score_Move_3_human;
                            //}

                            // Think deeper only if there is a piece capture
                            if ((Move_Analyzed < Thinking_Depth) && (!"".equals(ProsorinoKommati3)))
                            // v0.990 test
                            //if ( ((Move_Analyzed < Thinking_Depth) && (m_PlayerColor.equals("w")) && (Temp_Score_Move_1_human >= bestScoreLevel3))
                            //  || ((Move_Analyzed < Thinking_Depth) && (m_PlayerColor.equals("b")) && (Temp_Score_Move_1_human <= bestScoreLevel3)) )
                            {
                                    // Call ComputerMove for the HY throught process to continue
                                    Move_Analyzed = Move_Analyzed + 1;

                                    Who_Is_Analyzed = "HY";

                                    //v0.990
                                    String[][] Skakiera_Move_After_3_new = new String[8][8];

                                    //v0.990: Why copy everything in Skakiera_Move_After?
                                    //Just use Skakiera_Human_Thinking_3 directly! No!
                                    //Remember the problem with the "reference" of the array at with ElegxosNomimotitas!)
                                    //Arrays can be passed as arguments to method parameters. Because arrays are reference types, the method can change the value of the elements.
                                    //SOURCES...
                                    //https://docs.microsoft.com/en-us/dotnet/articles/csharp/programming-guide/arrays/passing-arrays-as-arguments]
                                    //http://stackoverflow.com/questions/10325323/passing-arrays-by-value-and-by-reference
                                    //http://stackoverflow.com/questions/967402/are-arrays-or-lists-passed-by-default-by-reference-in-c
                                    for (i = 0; i <= 7; i++)
                                    {
                                        for (j = 0; j <= 7; j++)
                                        {
                                            Skakiera_Move_After_3[(i)][(j)] = Skakiera_Human_Thinking_3[(i)][(j)];
                                            Skakiera_Move_After_3_new[(i)][(j)] = Skakiera_Human_Thinking_3[(i)][(j)];
                                        }
                                    }

                                    //v0.990: Skakiera_Move_After -> Skakiera_Move_After_3 -> Skakiera_Move_After_3_new
                                    if (Move_Analyzed == 4)
                                    {
                                        Analyze_Move_4_ComputerMove(Skakiera_Move_After_3_new);
                                    }
                            }

                            // Undo the move
                            Skakiera_Human_Thinking_3[(m_StartingColumnNumber3 - 1)][(m_StartingRank3 - 1)] = MovingPiece3;
                            Skakiera_Human_Thinking_3[(m_FinishingColumnNumber3 - 1)][(m_FinishingRank3 - 1)] = ProsorinoKommati3;

                            //v0.991
                            NodeLevel_3_count++;
                         }

                    } // For 4
                } // For 3

            } // IF

        } // For 2
    } // For 1
   
    Move_Analyzed = Move_Analyzed - 1;
    Who_Is_Analyzed = "HY";
}

public static void Analyze_Move_4_ComputerMove(String[][] Skakiera_Thinking_HY_4)
{
    // v0.990 change: The best score for every move will be stored at each level. Only if the new move analyzed
    // has a better score than the best score, will it be analyzed (target: trim the analysis tree)
    double bestScoreLevel4 = 0;

    // Δήλωση μεταβλητών που χρησιμοποιούνται στο βρόγχο "for" (δεν μπορεί να χρησιμοποιηθούν οι μεταβλητές i και j διότι αυτές οι
    // μεταβλητές είναι καθολικές και δημιουργείται πρόβλημα κατά την επιστροφή στην ComputerMove από την CheckMove)
    //v0.990: Initialized the values
    int iii4 = 0;
    int jjj4 = 0;
    String MovingPiece4 = "";
    String ProsorinoKommati4 = "";
    int m_StartingColumnNumber4 = 0;
    int m_FinishingColumnNumber4 = 0;
    int m_StartingRank4 = 0;
    int m_FinishingRank4 = 0;

    //v0.990
    String[][] Skakiera_Move_After_4 = new String[8][8];

    //huo_sw1.WriteLine(String.Concat("[Point 0] -> Σκακιέρα[5,1] = ", Skakiera_Thinking_HY_4[4, 0].ToString()));

    // Σκανάρισμα της σκακιέρας: Όταν εντοπίζεται κάποιο κομμάτι του υπολογιστή,
    // θα υπολογίζονται ΟΛΕΣ οι πιθανές κινήσεις του προς κάθε κατεύθυνση, ακόμα
    // και αυτές που δεν μπορεί να κάνει το κομμάτι. Στη συνέχεια, με τη βοήθεια
    // των συναρτήσεων ElegxosNomimotitas και ElegxosOrthotitas θα ελέγχεται το
    // αν η κίνηση είναι ορθή και νόμιμη. Αν είναι, η εν λόγω κίνηση θα γίνεται
    // προσωρινά στη σκακιέρα και θα καταγράφεται το σκορ της νέας θέσης που
    // προέκυψε

    // ΣΗΜΕΙΩΣΗ: Σε όλες τις στήλες και τις οριζόντιους προστίθεται η μονάδα (+1)
    // διότι πρέπει να μετατραπούν από το "σύστημα" μέτρησης "0-7" (που χρησιμο-
    // ποιείται στο παρακάτω "for i…next" αλλά και στο συμβολισμό του πίνακα
    // Skakiera) στο σύστημα μέτρησης "1-8" το οποίο χρησιμοποιείται στις
    // μεταβλητές Starting/Finishing_Column/Rank σε όλο το υπόλοιπο πρόγραμμα.

    for (iii4 = 0; iii4 <= 7; iii4++)
    {
        for (jjj4 = 0; jjj4 <= 7; jjj4++)
        {
            if (((Who_Is_Analyzed.equals("HY")) && ((((Skakiera_Thinking_HY_4[(iii4)][(jjj4)].equals("WK")) || (Skakiera_Thinking_HY_4[(iii4)][(jjj4)].equals("WQ")) || (Skakiera_Thinking_HY_4[(iii4)][(jjj4)].equals("White Rook")) || (Skakiera_Thinking_HY_4[(iii4)][(jjj4)].equals("WN")) || (Skakiera_Thinking_HY_4[(iii4)][(jjj4)].equals("WB")) || (Skakiera_Thinking_HY_4[(iii4)][(jjj4)].equals("WP"))) && (m_PlayerColor.equals("b"))) || (((Skakiera_Thinking_HY_4[(iii4)][(jjj4)].equals("BK")) || (Skakiera_Thinking_HY_4[(iii4)][(jjj4)].equals("BQ")) || (Skakiera_Thinking_HY_4[(iii4)][(jjj4)].equals("BR")) || (Skakiera_Thinking_HY_4[(iii4)][(jjj4)].equals("BN")) || (Skakiera_Thinking_HY_4[(iii4)][(jjj4)].equals("BB")) || (Skakiera_Thinking_HY_4[(iii4)][(jjj4)].equals("BP"))) && (m_PlayerColor.equals("w"))))))
            {
                //huo_sw1.WriteLine(String.Concat("[Point 1] -> Σκακιέρα[5,1] = ", Skakiera_Thinking_HY_4[4, 0].ToString()));

                for (int w = 0; w <= 7; w++)
                {
                    for (int r = 0; r <= 7; r++)
                    {
                        //huo_sw1.WriteLine(String.Concat("[Point 2] -> Σκακιέρα[5,1] = ", Skakiera_Thinking_HY_4[4, 0].ToString()));

                        //v0.990: Replaced m_StartingColumnNumber with m_StartingColumnNumber4
                        MovingPiece4 = Skakiera_Thinking_HY_4[(iii4)][(jjj4)];
                        m_StartingColumnNumber4 = iii4 + 1;
                        m_FinishingColumnNumber4 = w + 1;
                        m_StartingRank4 = jjj4 + 1;
                        m_FinishingRank4 = r + 1;
                        ProsorinoKommati4 = Skakiera_Thinking_HY_4[(m_FinishingColumnNumber4 - 1)][(m_FinishingRank4 - 1)];

                        // Έλεγχος της κίνησης

                        // Validity and legality of the move has been checked in CheckMove
                        // CheckMove(Skakiera_Thinking_HY_4);

                        // Check validity and legality
                        // Necessary values for variables for the ElegxosOrthotitas (check move corr1ectness) and
                        // ElegxosNomimotitas (check move legality) function to...function properly.
                        m_WhoPlays = "Human";
                        m_WrongColumn = false;
                        //v0.990: MovingPiece -> MovingPiece4

                        m_OrthotitaKinisis = ElegxosOrthotitas(Skakiera_Thinking_HY_4, 0, m_StartingRank4, m_StartingColumnNumber4, m_FinishingRank4, m_FinishingColumnNumber4, MovingPiece4);
                        m_NomimotitaKinisis = ElegxosNomimotitas(Skakiera_Thinking_HY_4, 0, m_StartingRank4, m_StartingColumnNumber4, m_FinishingRank4, m_FinishingColumnNumber4, MovingPiece4);
                        // Restore normal value of m_WhoPlays
                        m_WhoPlays = "HY";

                        // If all ok, then do the move and measure it
                        if ((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true))
                        {
                            //huo_sw1.WriteLine(string.Concat("Hu move 1: Found a legal move!"));
                            //huo_sw1.WriteLine(String.Concat("[Point 5] -> Σκακιέρα[5,1] = ", Skakiera_Thinking_HY_4[4, 0].ToString()));

                            // Do the move
                            //v0.990: ProsorinoKommati -> ProsorinoKommati4, MovingPiece -> MovingPiece4
                            ProsorinoKommati4 = Skakiera_Thinking_HY_4[(m_FinishingColumnNumber4 - 1)][(m_FinishingRank4 - 1)];
                            Skakiera_Thinking_HY_4[(m_StartingColumnNumber4 - 1)][(m_StartingRank4 - 1)] = "";
                            Skakiera_Thinking_HY_4[(m_FinishingColumnNumber4 - 1)][(m_FinishingRank4 - 1)] = MovingPiece4;

                            //v0.991
                            //NodeLevel_4_count++;
                            //v0.980: Removed humanDangerParameter from every call of countScore
                            Temp_Score_Move_4 = CountScore(Skakiera_Thinking_HY_4);

                            // v0.992: Score and parent for each move analyzed are stored on the spot and not at the end of the thinking depth
                            // since some branches of the thinking tree might be trimmed, thus not available at the end of the thinking depth for
                            // their score and parent to be stored!
                            // Store scores
                            NodesAnalysis4[NodeLevel_4_count][0] = Temp_Score_Move_4;
                            // Store parents
                            NodesAnalysis4[NodeLevel_4_count][1] = NodeLevel_3_count;
                                        
                            // v0.990 change
                            // Store the best score at this level
                            //if ((m_PlayerColor.equals("b")) && (Temp_Score_Move_4 > bestScoreLevel4))
                            //{
                            //        bestScoreLevel4 = Temp_Score_Move_4;
                            //}
                            //else if ((m_PlayerColor.equals("w")) && (Temp_Score_Move_4 < bestScoreLevel4))
                            //{
                            //        bestScoreLevel4 = Temp_Score_Move_4;
                            //}

                            // v0.990 change: Added back the part which calls deeper levels of analysis
                            // v0.990 change: Must trim the tree or else the app does not work and consums a lot of memory!
                            //if (Move_Analyzed < Thinking_Depth)
                            // v0.990 Move 4 changes: Trim the tree!
                            if (((Move_Analyzed < Thinking_Depth) && (m_PlayerColor.equals("w")) && (Temp_Score_Move_4 <= bestScoreLevel4)) || ((Move_Analyzed < Thinking_Depth) && (m_PlayerColor.equals("b")) && (Temp_Score_Move_4 >= bestScoreLevel4)))
                            {
                                Move_Analyzed = Move_Analyzed + 1;

                                //v0.990: Skakiera_Move_After -> Skakiera_Move_After_4
                                for (i = 0; i <= 7; i++)
                                {
                                    for (j = 0; j <= 7; j++)
                                    {
                                        Skakiera_Move_After_4[(i)][(j)] = Skakiera_Thinking_HY_4[(i)][(j)];
                                    }
                                }

                                Who_Is_Analyzed = "Human";
                                //V0.980 REMOVED First_Call_Human_Thought = true;

                                // v0.990 Move 4 changes
                                // Check human move
                                //v0.990: Skakiera_Move_After -> Skakiera_Thinking_HY_4
                                if (Move_Analyzed == 5)
                                {
                                    //Analyze_Move_5_HumanMove(Skakiera_Move_After_4);
                                }
                            }

                            // Undo the move
                            Skakiera_Thinking_HY_4[(m_StartingColumnNumber4 - 1)][(m_StartingRank4 - 1)] = MovingPiece4;
                            Skakiera_Thinking_HY_4[(m_FinishingColumnNumber4 - 1)][(m_FinishingRank4 - 1)] = ProsorinoKommati4;

                            //v0.991
                            NodeLevel_4_count++;
                        }

                    } // FOR 4
                } // FOR 3

            } // IF
        }
    }

    Move_Analyzed = Move_Analyzed - 1;
    Who_Is_Analyzed = "Human";
}

public static void FindAttackers(String[][] SkakieraAttackers)
{
			//v0.990: Initialized the values
			String MovingPiece_Attack = "";
			int m_StartingRank_Attack = 0;
			int m_StartingColumnNumber_Attack = 0;
			int m_FinishingRank_Attack = 0;
			int m_FinishingColumnNumber_Attack = 0;

			// Scan the chessboard . if a piece of HY is found . check all
			// possible destinations in the chessboard . check correctness of
			// the move analyzed . check legality of the move analyzed . if
			// correct and legal, then do the move.
			// NOTE: In all column and rank numbers I add +1, because I must transform
			// them from the 0...7 'measure system' of the chessboard (='Skakiera' in Greek) table
			// to the 1...8 'measure system' of the chessboard.

			for (int iii2 = 0; iii2 <= 7; iii2++)
			{
				for (int jjj2 = 0; jjj2 <= 7; jjj2++)
				{
					if ((((SkakieraAttackers[(iii2)][(jjj2)].equals("WK")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("WQ")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("White Rook")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("WN")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("WB")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("WP"))) && (m_PlayerColor.equals("w"))) || (((SkakieraAttackers[(iii2)][(jjj2)].equals("BK")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("BQ")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("BR")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("BN")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("BB")) || (SkakieraAttackers[(iii2)][(jjj2)].equals("BP"))) && (m_PlayerColor.equals("b"))))
					{

						MovingPiece_Attack = SkakieraAttackers[(iii2)][(jjj2)];
						m_StartingColumnNumber_Attack = iii2 + 1;
						m_StartingRank_Attack = jjj2 + 1;

						// find squares where the Hu opponent can hit
						for (int w2 = 0; w2 <= 7; w2++)
						{
							for (int r2 = 0; r2 <= 7; r2++)
							{
								m_FinishingColumnNumber_Attack = w2 + 1;
								m_FinishingRank_Attack = r2 + 1;

								// check the move
								m_WhoPlays = "Human";
								m_WrongColumn = false;
								m_OrthotitaKinisis = ElegxosOrthotitas(Skakiera, 1, m_StartingRank_Attack, m_StartingColumnNumber_Attack, m_FinishingRank_Attack, m_FinishingColumnNumber_Attack, MovingPiece_Attack);
								if (m_OrthotitaKinisis == true)
								{
									m_NomimotitaKinisis = ElegxosNomimotitas(Skakiera, 1, m_StartingRank_Attack, m_StartingColumnNumber_Attack, m_FinishingRank_Attack, m_FinishingColumnNumber_Attack, MovingPiece_Attack);
								}
								// restore normal value of m_whoplays
								m_WhoPlays = "HY";
								// 2012: If a pawn is moving, then take into account only moves of eating other pieces!
								// and not moves of moving forward
								if ((MovingPiece_Attack.equals("WP")) || (MovingPiece_Attack.equals("BP")))
								{
									if (m_FinishingColumnNumber_Attack == m_StartingColumnNumber_Attack)
									{
										m_OrthotitaKinisis = false;
									}
								}

								if ((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true))
								{
									// Another attacker on that square found!
									Number_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Number_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 1;
									// v0.96
									//Skakiera_Dangerous_Squares[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = "Danger";

									//2012 new
									//v0.980: Removed Attackers_coordinates_column/rank since they are not used!
									//Attackers_coordinates_column[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = m_StartingColumnNumber_Attack - 1;
									//Attackers_coordinates_rank[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = m_StartingRank_Attack - 1;

									// Calculate the value (total value) of the attackers
									//MessageBox.Show(string.Concat("Added something to the value of attackers: ", MovingPiece_Attack.ToString()));

									if ((MovingPiece_Attack.equals("White Rook")) || (MovingPiece_Attack.equals("BR")))
									{
										Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 5;
									}
									else if ((MovingPiece_Attack.equals("WB")) || (MovingPiece_Attack.equals("BB")))
									{
										Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 3;
									}
									else if ((MovingPiece_Attack.equals("WN")) || (MovingPiece_Attack.equals("BN")))
									{
										Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 3;
									}
									else if ((MovingPiece_Attack.equals("WQ")) || (MovingPiece_Attack.equals("BQ")))
									{
										Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 9;
									}
									else if ((MovingPiece_Attack.equals("WP")) || (MovingPiece_Attack.equals("BP")))
									{
										Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_attackers[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 1;
									}
									//v0.95
									//else if ((MovingPiece_Attack.equals("WK")) || (MovingPiece_Attack.equals("BK")))
									//    Value_of_attackers[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = Value_of_attackers[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] + 15;
								}
							}
						}
					}
				}
			}


		}

public static void FindDefenders(String[][] SkakieraDefenders)
{
			//v0.990: Initialized the values
			String MovingPiece_Attack = "";
			int m_StartingRank_Attack = 0;
			int m_StartingColumnNumber_Attack = 0;
			int m_FinishingRank_Attack = 0;
			int m_FinishingColumnNumber_Attack = 0;

			// Find squares that are also 'protected' by a piece of the HY.
			// If protected, then the square is not really dangerous

			// Changed in version 0.5
			// Initialize all variables used to find exceptions in the non-dangerous squares.
			// Exceptions definition: If Hu can hit a square and the computer defends it with its pieces, then the
			// square is not dangerous. However, if the computer has only one (1) piece to defend that square, then
			// it cannot move that specific piece to that square (because then the square would have no defenders and
			// would become again a dangerous square!).

			for (int iii3 = 0; iii3 <= 7; iii3++)
			{
				for (int jjj3 = 0; jjj3 <= 7; jjj3++)
				{
					if ((((SkakieraDefenders[(iii3)][(jjj3)].equals("WK")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("WQ")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("White Rook")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("WN")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("WB")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("WP"))) && (m_PlayerColor.equals("b"))) || (((SkakieraDefenders[(iii3)][(jjj3)].equals("BK")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("BQ")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("BR")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("BN")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("BB")) || (SkakieraDefenders[(iii3)][(jjj3)].equals("BP"))) && (m_PlayerColor.equals("w"))))
					{
						MovingPiece_Attack = SkakieraDefenders[(iii3)][(jjj3)];
						m_StartingColumnNumber_Attack = iii3 + 1;
						m_StartingRank_Attack = jjj3 + 1;

						for (int w1 = 0; w1 <= 7; w1++)
						{
							for (int r1 = 0; r1 <= 7; r1++)
							{

								m_FinishingColumnNumber_Attack = w1 + 1;
								m_FinishingRank_Attack = r1 + 1;

								// Έλεγχος της κίνησης
								// Απόδοση τιμών στις μεταβλητές m_WhoPlays και m_WrongColumn, οι οποίες είναι απαραίτητες για να λειτουργήσει σωστά οι συναρτήσεις ElegxosNomimotitas και ElegxosOrthotitas
								m_WhoPlays = "Human";
								m_WrongColumn = false;
								m_OrthotitaKinisis = ElegxosOrthotitas(SkakieraDefenders, 1, m_StartingRank_Attack, m_StartingColumnNumber_Attack, m_FinishingRank_Attack, m_FinishingColumnNumber_Attack, MovingPiece_Attack);
								if (m_OrthotitaKinisis == true)
								{
									m_NomimotitaKinisis = ElegxosNomimotitas(SkakieraDefenders, 1, m_StartingRank_Attack, m_StartingColumnNumber_Attack, m_FinishingRank_Attack, m_FinishingColumnNumber_Attack, MovingPiece_Attack);
								}
								// Επαναφορά της κανονικής τιμής της m_WhoPlays
								m_WhoPlays = "HY";

								// NEW
								// You can count for all moves that "defend" a square,
								// except the move of a pawn forward! :)
								if ((MovingPiece_Attack.equals("WP")) || (MovingPiece_Attack.equals("BP")))
								{
									if (m_FinishingColumnNumber_Attack == m_StartingColumnNumber_Attack)
									{
										m_OrthotitaKinisis = false;
									}
								}

								m_WhoPlays = "HY";
								if ((m_OrthotitaKinisis == true) && (m_NomimotitaKinisis == true))
								{
									// A new defender for that square is found!
									Number_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Number_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 1;

									// Calculate the value (total value) of the defenders
									//MessageBox.Show(string.Concat("Added something to the value of defenders for (", (m_FinishingColumnNumber_Attack).ToString(), ",", (m_FinishingRank_Attack).ToString(), "): ", MovingPiece_Attack.ToString()));

									if ((MovingPiece_Attack.equals("White Rook")) || (MovingPiece_Attack.equals("BR")))
									{
										Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 5;
									}
									else if ((MovingPiece_Attack.equals("WB")) || (MovingPiece_Attack.equals("BB")))
									{
										Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 3;
									}
									else if ((MovingPiece_Attack.equals("WN")) || (MovingPiece_Attack.equals("BN")))
									{
										Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 3;
									}
									else if ((MovingPiece_Attack.equals("WQ")) || (MovingPiece_Attack.equals("BQ")))
									{
										Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 9;
									}
									else if ((MovingPiece_Attack.equals("WP")) || (MovingPiece_Attack.equals("BP")))
									{
										Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 1;
									}
									else if ((MovingPiece_Attack.equals("WK")) || (MovingPiece_Attack.equals("BK")))
									{
										Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] = Value_of_defenders[(m_FinishingColumnNumber_Attack - 1)][(m_FinishingRank_Attack - 1)] + 15;
									}

									//v0.980: Removed Exception_defender_column/ rank since they are not used!
									// Exception for Defenders!
									// If the defender found is the only one, then that defender cannot move to that square,
									// since then the square would be again dangerous (since its only defender would have moved into it!)
									// If more than one defenders is found, then no exceptions exist.
									//if (Number_of_defenders[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] == 1)
									//{
									//    Exception_defender_column[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = (m_StartingColumnNumber_Attack - 1);
									//    Exception_defender_rank[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = (m_StartingRank_Attack - 1);

									//    // DEBUGGING
									//    //if (((m_FinishingColumnNumber_Attack - 1) == 2) && ((m_FinishingRank_Attack - 1) == 4))
									//    //{
									//    //    MessageBox.Show("hOU");
									//    //    MessageBox.Show(String.Concat("Move found: ", m_StartingColumnNumber_Attack.ToString(), m_StartingRank_Attack.ToString(), "->", m_FinishingColumnNumber_Attack.ToString(), m_FinishingRank_Attack.ToString()));
									//    //    MessageBox.Show(String.Concat("Exception column: ",Exception_defender_column[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)]));
									//    //    MessageBox.Show(String.Concat("Exception rank: ",Exception_defender_rank[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)]));
									//    //    MessageBox.Show(String.Concat("Exception column: ",(iii3).ToString()));
									//    //    MessageBox.Show(String.Concat("Exception rank: ",(jjj3).ToString() ));
									//    //}
									//    // PLAYING
									//}
									//else if (Number_of_defenders[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] > 1)
									//{
									//    Exception_defender_column[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = -99;
									//    Exception_defender_rank[(m_FinishingColumnNumber_Attack - 1), (m_FinishingRank_Attack - 1)] = -99;
									//}

								}
							}
						}
					}
				}
			}
		}

public static void PawnPromotion()
{
			for (i = 0; i <= 7; i++)
			{
				if ((Skakiera[(i)][(0)].equals("BP")) && (m_WhoPlays.equals("Human")))
				{
					///////////////////////////
					// promote pawn
					///////////////////////////

					System.out.println("Promote to: 1. Queen, 2. Rook, 3. Knight, 4. Bishop? ");
					choise_of_user = Integer.parseInt(new Scanner(System.in).nextLine());

					switch (choise_of_user)
					{
						case 1:
							Skakiera[(i)][(0)] = "BQ";
							break;

						case 2:
							Skakiera[(i)][(0)] = "BR";
							break;

						case 3:
							Skakiera[(i)][(0)] = "BN";
							break;

						case 4:
							Skakiera[(i)][(0)] = "BB";
							break;
					};

				}


				if ((Skakiera[(i)][(7)].equals("WP")) && (m_WhoPlays.equals("Human")))
				{
					///////////////////////////
					// promote pawn
					///////////////////////////

					System.out.println("Promote to: 1. Queen, 2. Rook, 3. Knight, 4. Bishop? ");
					choise_of_user = Integer.parseInt(new Scanner(System.in).nextLine());

					switch (choise_of_user)
					{
						case 1 -> Skakiera[(i)][(0)] = "WQ";

						case 2 -> Skakiera[(i)][(0)] = "White Rook";

						case 3 -> Skakiera[(i)][(0)] = "WN";

						case 4 -> Skakiera[(i)][(0)] = "WB";
					}
				}

			}
		}

}
