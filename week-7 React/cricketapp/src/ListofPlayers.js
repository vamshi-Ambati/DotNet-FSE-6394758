import React from "react";

const ListofPlayers = ({ players }) => (
  <ul>
    {players.map((player, i) => (
      <li key={i}>{player.name} - {player.score}</li>
    ))}
  </ul>
);

export default ListofPlayers;
