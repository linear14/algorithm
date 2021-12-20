const solution = (m, n, board) => {
  let oldAns = 0;
  let newAns = 0;
  board = board.map(i => i.split(''));
  let tempBoard = Array.from({ length: n }, () => []);

  // 해당 블록 기준 하단 좌우로 부러질 수 있는지 확인
  const isSomethingBroken = (x, y) => {
    const now = board[y][x];
    // 왼족 체크
    if(x > 0 && x <= n - 1 && y >= 0 && y < m - 1 && board[y + 1][x] === now && board[y][x - 1] === now && board[y + 1][x - 1] === now) {
      return true;
    }
    // 오른쪽 체크
    if(x >= 0 && x < n - 1 && y >= 0 && y < m - 1 && board[y + 1][x] === now && board[y][x + 1] === now && board[y + 1][x + 1] === now) {
      return true;
    }
    // 부러진 곳 없는 경우
    return false;
  }

  do {
    oldAns = newAns;

    // 아래서부터 위로 올라가면서 체크
    for(let x = 0; x < n; x++) {
      let isPreviousBroken = false;

      for(let y = m - 1; y >= 0; y--) {
        if(board[y][x]) {
          if(!isSomethingBroken(x, y)) {
            if(isPreviousBroken) {
              tempBoard[x].pop();
              isPreviousBroken = false;
            }
            tempBoard[x].push(board[y][x]);
          }
          else { 
            isPreviousBroken = true;  
          }
        }
      }
      if(isPreviousBroken) { tempBoard[x].pop(); }
    }

    for(let i = 0; i < n; i++) {
      for(let j = 0; j < m; j++) {
        board[m - j - 1][i] = tempBoard[i].length > j ? tempBoard[i][j] : null;
      }
    }

    newAns = (n * m - tempBoard.flat().length);
    tempBoard = Array.from({ length: n }, () => []);
  } while(oldAns !== newAns)

  return newAns;
}

const testData = [
  { m	: 4, n: 5, board: ["CCBDE", "AAADE", "AAABF", "CCBBF"] },
  { m	: 6, n: 6, board: ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"] },
];

testData.forEach(({ m, n, board }) => {
  console.log(solution(m, n, board));
});
