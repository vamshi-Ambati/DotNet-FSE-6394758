import React from "react";

const EvenPlayers = ({ players }) => {
  const even = players.filter((_, i) => i % 2 !== 0);
  return (
    <ul>
      {even.map((player, i) => <li key={i}>{player}</li>)}
    </ul>
  );
};

export default EvenPlayers;
