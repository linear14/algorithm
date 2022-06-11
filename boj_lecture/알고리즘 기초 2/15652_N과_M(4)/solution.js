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
  const bt = (depth) => {
    if(depth === m) {
      ans.push(arr.join(' '));
      return;
    }

    for(let i = 1; i <= n; i++) {
      if(depth === 0 || arr[depth - 1] <= i) {
        arr.push(i);
        bt(depth + 1);
        arr.pop();
      }
    }
  }

  bt(0);
  console.log(ans.join('\n'));
});