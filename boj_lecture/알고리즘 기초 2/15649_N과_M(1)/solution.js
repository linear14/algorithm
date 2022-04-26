const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n, m;
rl.on('line', (input) => {
  [n, m] = input.split(' ').map(i => +i);
  rl.close();
}).on('close', () => {
  const ans = [];
  const arr = [];
  const isVisited = Array(n + 1).fill(false);
  
  function bt(depth) {
    if(depth === m) {
      ans.push(arr.join(' '));
      return;
    }

    for(let i = 1; i <= n; i++) {
      if(!isVisited[i]) {
        arr.push(i);
        isVisited[i] = true;
        bt(depth + 1);
        isVisited[i] = false;
        arr.pop();
      }
    }
  }

  bt(0);
  console.log(ans.join('\n'));
});