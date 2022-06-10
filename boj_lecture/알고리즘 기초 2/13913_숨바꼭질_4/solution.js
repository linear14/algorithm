const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const functions = [(n) => n - 1, (n) => n + 1, (n) => 2 * n]; 
let n, k;

rl.on('line', (input) => {
  [n, k] = input.split(' ').map(i => +i);
  rl.close();
}).on('close', () => {
  
  const q = [];
  const isVisited = Array(100001).fill(false);
  let index = 0;
  
  isVisited[n] = true;
  q.push({ cur: n, depth: 0 });

  while(q.length > 0) {
    const { cur, depth, previousIndex } = q[index];
    if(cur === k) {
      const paths = [cur];
      let parentIndex = previousIndex;
      while(parentIndex !== undefined) {
        const parent = q[parentIndex];
        paths.push(parent.cur);
        parentIndex = parent.previousIndex;
      }
      console.log(depth);
      console.log(paths.reverse().join(' '));
      return;  
    }

    for(let i = 0; i < 3; i++) {
      const nextFunction = functions[i];
      const next = nextFunction(cur);
      
      if(next >= 0 && next <= 100000 && !isVisited[next]) {
        isVisited[next] = true;
        q.push({ cur: next, depth: depth + 1, previousIndex: index });
      }
    }
    index++;
  }
});