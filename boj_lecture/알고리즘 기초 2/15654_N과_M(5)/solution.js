const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n, m;
let arr;

rl.on('line', (input) => {
  if(!n) {
    [n, m] = input.split(' ').map(i => +i);
  }
  else {
    arr = input.split(' ').map(i => +i).sort((a, b) => a - b);
    rl.close();
  }
}).on('close', () => {
  const ans = [];
  
  const tempAns = [];
  const isVisited = Array(arr.length).fill(false);
  const bt = (depth) => {
    if(depth === m) {
      ans.push(tempAns.join(' '));
      return;
    }

    for(let i = 0; i < arr.length; i++) {
      const next = arr[i];
      
      if(!isVisited[i]) {
        tempAns.push(next);
        isVisited[i] = true;
        bt(depth + 1);
        tempAns.pop();
        isVisited[i] = false;
      }
    }
  } 

  bt(0);
  console.log(ans.join('\n'));
});