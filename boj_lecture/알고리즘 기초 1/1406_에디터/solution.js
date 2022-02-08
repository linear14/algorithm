const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

let n;
let left;
const right = [];
const cmds = [];

rl.on('line', (input) => {
  if(!left) {
    left = input.split('');
  }
  else if(!n) {
    n = +input;
  }
  else {
    cmds.push(input.split(' '));
    if(cmds.length === n) rl.close();
  }
}).on('close', () => {
  console.log(solution());
})

const solution = () => {
  for(let i = 0; i < n; i++) {
    const [cmd, x] = cmds[i];
    if(cmd === 'L' && left.length !== 0) {
      right.push(left.pop());
    }
    else if(cmd === 'D' && right.length !== 0) {
      left.push(right.pop());
    }
    else if(cmd === 'B' && left.length !== 0) {
      left.pop();
    }
    else if(cmd === 'P') {
      left.push(x);
    }
  }
  
  return left.join('') + right.reverse().join('');
}