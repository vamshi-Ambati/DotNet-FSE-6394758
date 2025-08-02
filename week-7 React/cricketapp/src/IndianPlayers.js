import React from "react";

// Using ES6 class fundamentals
class IndianPlayers extends React.Component {
  render() {
    // Using ES6 destructuring
    const { players } = this.props;

    // Destructuring arrays
    const [player1, player2, player3, ...remaining] = players;

    // Using ES6 spread operator to merge arrays
    const T20players = ["Virat", "Rohit", "Bumrah"];
    const RanjiTrophyPlayers = ["Pujara", "Rahane", "Shami"];
    const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

    return (
      <div>
        <h2>Indian Team</h2>

        <h3>Odd Team Players (Destructured)</h3>
        <p>Player 1: {player1.name}</p>
        <p>Player 3: {player3.name}</p>

        <h3>Even Team Players (Destructured)</h3>
        <p>Player 2: {player2.name}</p>
        <p>Remaining Players: {remaining.map((p) => p.name).join(", ")}</p>

        <h3>Merged Players (ES6 Spread)</h3>
        <ul>
          {mergedPlayers.map((player, index) => (
            <li key={index}>{player}</li>
          ))}
        </ul>
      </div>
    );
  }
}

// ES6 class inheritance example
class ExtendedIndianPlayers extends IndianPlayers {
  // Can add additional methods or override existing ones
}

export default ExtendedIndianPlayers;
