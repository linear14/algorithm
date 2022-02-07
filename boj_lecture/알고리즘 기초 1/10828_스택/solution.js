const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
const stack = [];
const ans = [];
rl.on('line', (input) => {
  if(!n) {
    n = +input;
  }
  else {
    const [cmd, x] = input.split(' ');
    execute(cmd, x)
    if(--n === 0) {
      console.log(ans.join('\n'));
      rl.close();
    }
  }
})

const push = (x) => {
  stack.push(+x);
}
const pop = () => stack.pop() || -1
const size = () => stack.length
const empty = () => +(stack.length === 0)
const top = () => stack[stack.length - 1] || -1

const execute = (cmd, x) => {
  switch(cmd) {
    case 'push': push(Number(x)); break;
    case 'pop': ans.push(pop()); break;
    case 'size': ans.push(size()); break;
    case 'empty': ans.push(empty()); break;
    case 'top': ans.push(top()); break;
    default: break;
  }
}