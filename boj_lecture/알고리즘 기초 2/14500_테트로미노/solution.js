const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n, m;
const arr = [];
rl.on('line', (input) => {
  if(!n) [n, m] = input.split(' ').map(i => +i);
  else {
    arr.push(input.split(' ').map(i => +i));
    if(arr.length === n) rl.close();
  }
}).on('close', () => {
  let ans = 0;
  let blocks;
  let removes;

  const sumBlocks = (i, j) => {
    return blocks.reduce((pre, cur) => pre + arr[i + cur[0]][j + cur[1]], 0);
  }

  const sumBlocksRemoved = (r, i, j) => {
    return arr[i + r[0][0]][j + r[0][1]] + arr[i + r[1][0]][j + r[1][1]]
  }

  // 1 x 4
  blocks = [[0, 0], [0, 1], [0, 2], [0, 3]];
  for(let i = 0; i < n; i++) {
    for(let j = 0; j < m - 3; j++) {
      const sum = sumBlocks(i, j);
      ans = Math.max(ans, sum);
    }
  }

  // 4 x 1
  blocks = [[0, 0], [1, 0], [2, 0], [3, 0]];
  for(let i = 0; i < n - 3; i++) {
    for(let j = 0; j < m; j++) {
      const sum = sumBlocks(i, j);
      ans = Math.max(ans, sum);
    }
  }

  // 2 x 3
  blocks = [[0, 0], [0, 1], [0, 2], [1, 0], [1, 1], [1, 2]];
  removes = [
    [[0, 0], [0, 1]], [[0, 0], [0, 2]], [[0, 0], [1, 0]], [[0, 0], [1, 2]], [[0, 1], [0, 2]], 
    [[0, 2], [1, 0]], [[0, 2], [1, 2]], [[1, 0], [1, 1]], [[1, 0], [1, 2]], [[1, 1], [1, 2]]
  ];
  for(let i = 0; i < n - 1; i++) {
    for(let j = 0; j < m - 2; j++) {
      const sum = sumBlocks(i, j);
      
      for(let k = 0; k < removes.length; k++) {
        const r = removes[k];
        ans = Math.max(ans, sum - sumBlocksRemoved(r, i, j));
      }
    }
  }

  // 3 x 2
  blocks = [[0, 0], [0, 1], [1, 0], [1, 1], [2, 0], [2, 1]];
  removes = [
    [[0, 0], [0, 1]], [[0, 0], [1, 0]], [[0, 0], [2, 0]], [[0, 0], [2, 1]], [[0, 1], [1, 1]], 
    [[0, 1], [2, 0]], [[0, 1], [2, 1]], [[1, 0], [2, 0]], [[1, 1], [2, 1]], [[2, 0], [2, 1]]
  ];
  for(let i = 0; i < n - 2; i++) {
    for(let j = 0; j < m - 1; j++) {
      const sum = sumBlocks(i, j);

      for(let k = 0; k < removes.length; k++) {
        const r = removes[k];
        ans = Math.max(ans, sum - sumBlocksRemoved(r, i, j));
      }
    }
  }

  console.log(ans);
});