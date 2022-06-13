const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const nextFunctions = [
  ({ count }) => ({ newCount: count, newClipboard: count }), 
  ({ count, clipboard }) => ({ newCount: count + clipboard, newClipboard: clipboard }), 
  ({ count, clipboard }) => ({ newCount: count - 1, newClipboard: clipboard })
];
let s;

rl.on('line', (input) => {
  s = +input;
  rl.close();
}).on('close', () => {
  const SIZE_DOUBLE = 2 * s + 1;
  const isVisited = Array.from({ length: SIZE_DOUBLE }, () => Array(SIZE_DOUBLE).fill(false));
  const q = [{ count: 1, clipboard: undefined, depth: 0 }];
  let qIndex = 0;
  isVisited[1][0] = true;

  while(q.length > qIndex) {
    const { count, clipboard, depth } = q[qIndex];
    
    if(count === s) {
      console.log(depth);
      return;
    }

    if(qIndex !== 0) {
      for(let i = 0; i < 3; i++) {
        const nextFunction = nextFunctions[i];
        const { newCount, newClipboard } = nextFunction({ count, clipboard });
        if(newCount > 0 && newCount < SIZE_DOUBLE && !isVisited[newCount][newClipboard]) {
          isVisited[newCount][newClipboard] = true;
          q.push({ count: newCount, clipboard: newClipboard, depth: depth + 1 });
        }
      }
    }
    else {
      const { newCount, newClipboard } = nextFunctions[0]({ count });
      isVisited[newCount][newClipboard] = true;
      q.push({ count: newCount, clipboard: newClipboard, depth: depth + 1});
    }

    qIndex++;
  }
});