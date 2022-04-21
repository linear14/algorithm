const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n, m;
const arr = [];
rl.on('line', (input) => {
  if(!n) {
    [n, m] = input.split(' ').map(i => +i);
  }
  else {
    arr.push(input.split('').map(i => +i));
    if(arr.length === n) {
      rl.close();
    }
  }
}).on('close', () => {
  const dx = [0, 0, 1, -1];
  const dy = [1, -1, 0, 0];
  const isVisited = Array.from({ length: n }, () => Array(m).fill(false));
  const q = [{ cn: 0, cm: 0, count: 1 }];
  isVisited[0][0] = true;

  while(q.length > 0) {
    const { cn, cm, count } = q.shift();

    if(cn === n-1 && cm === m-1) {
      console.log(count);
      break;
    }

    for(let i = 0; i < 4; i++) {
      const nn = cn + dx[i];
      const nm = cm + dy[i];

      if(nn >= 0 && nn < n && nm >= 0 && nm < m && !isVisited[nn][nm]) {
        if(arr[nn][nm] === 1) {
          q.push({ cn: nn, cm: nm, count: count + 1 });
          isVisited[nn][nm] = true;
        }
      }
    }

  }
});