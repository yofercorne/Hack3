import React, { useState } from 'react';

function Square({ value, onSquareClick, isWinning }) {
  const squareClassName = isWinning ? 'square winning' : 'square';

  return (
    <button className={squareClassName} onClick={onSquareClick}>
      {value}
    </button>
  );
}

function Board({ xIsNext, squares, onPlay }) {
  function handleClick(i) {
    if (calculateWinner(squares) || squares[i]) {
      return;
    }
    const nextSquares = squares.slice();
    if (xIsNext) {
      nextSquares[i] = 'X';
    } else {
      nextSquares[i] = 'O';
    }
    onPlay(nextSquares);
  }

  const winner = calculateWinner(squares);
  let status;
  if (winner) {
    status = 'Winner: ' + winner;
  } else if (squares.every((square) => square)) {
    status = 'Empate';
  } else {
    status = 'Next player: ' + (xIsNext ? 'X' : 'O');
  }

  let winningSquares = null;
  if (winner) {
    const [a, b, c] = calculateWinningLine(squares);
    winningSquares = [a, b, c];
  }

  const boardRows = [];
  for (let row = 0; row < 3; row++) {
    const rowSquares = [];
    for (let col = 0; col < 3; col++) {
      const i = 3 * row + col;
      rowSquares.push(
        <Square
          key={i}
          value={squares[i]}
          onSquareClick={() => handleClick(i)}
          isWinning={winningSquares && winningSquares.includes(i)}
        />
      );
    }
    boardRows.push(
      <div key={row} className="board-row">
        {rowSquares}
      </div>
    );
  }

  return (
    <div>
      <div className="status">{status}</div>
      {boardRows}
    </div>
  );
}

function Game() {
  const [history, setHistory] = useState([Array(9).fill(null)]);
  const [currentMove, setCurrentMove] = useState(0);
  const [isAscending, setIsAscending] = useState(true);

  const xIsNext = currentMove % 2 === 0;
  const currentSquares = history[currentMove];

  function handlePlay(nextSquares) {
    const nextHistory = history.slice(0, currentMove + 1).concat([nextSquares]);
    setHistory(nextHistory);
    setCurrentMove(nextHistory.length - 1);
  }
  function jumpTo(nextMove) {
    setCurrentMove(nextMove);
  }

  function toggleSortOrder() {
    setIsAscending(!isAscending);
  }

  
  const moves = history.map((squares, move) => {
    const description = move ? `Go to move #${move}` : 'Go to game start';
    let location = '';
  
    if (move > 0) {
      
      const prevSquares = history[move - 1];
      const currentSquares = history[move];
      let changedIndex = null;
  
      for (let i = 0; i < currentSquares.length; i++) {
        if (prevSquares[i] !== currentSquares[i]) {
          changedIndex = i;
          break;
        }
      }
  
      if (changedIndex !== null) {
        const col = 1 + (changedIndex % 3);
        const row = 1 + Math.floor(changedIndex / 3);
        location = `(${row}, ${col})`;
      }
    }
  
    if (move === currentMove) {
      return (
        <li key={move}>
          <strong>Estás en el movimiento #{move} {location}</strong>
        </li>
      );
    } else {
      return (
        <li key={move}>
          <button onClick={() => jumpTo(move)}>
            {description} {location}
          </button>
        </li>
      );
    }
  });
  
    
   
 
  if (!isAscending) {
    moves.reverse();
  }

  return (
    <div className="game">
      <div className="game-board">
        <Board xIsNext={xIsNext} squares={currentSquares} onPlay={handlePlay} />
      </div>
      <div className="game-info">
        <div>
          <button onClick={toggleSortOrder}>
            Toggle Sort Order: {isAscending ? 'Ascending' : 'Descending'}
          </button>
        </div>
        <ol>{moves}</ol>
      </div>
    </div>
  );
}

function calculateWinner(squares) {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];
  for (let i = 0; i < lines.length; i++) {
    const [a, b, c] = lines[i];
    if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
      return squares[a];
    }
  }
  return null;
}

function calculateWinningLine(squares) {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];
  for (let i = 0; i < lines.length; i++) {
    const [a, b, c] = lines[i];
    if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
      return [a, b, c];
    }
  }
  return null;
}

export default Game;


