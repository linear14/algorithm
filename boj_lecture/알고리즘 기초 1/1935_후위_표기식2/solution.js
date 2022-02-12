const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const alphabets = [
  'A', 'B', 'C', 'D', 'E', 'F', 'G', 
  'H', 'I', 'J', 'K', 'L', 'M', 'N', 
  'O', 'P', 'Q', 'R', 'S', 'T', 'U', 
  'V', 'W', 'X', 'Y', 'Z'
];

let n;
let tokens;
const mapper = {};
let mapperSize = 0;

rl.on('line', (input) => {
  if(!n) {
    n = +input;
  }
  else if(!tokens) {
    tokens = input.split('');
  }
  else {
    mapper[alphabets[mapperSize]] = +input;
    if(n === ++mapperSize) rl.close();
  }
}).on('close', () => {
  console.log(solution());
})

const sum = (a, b) => a + b;
const subtract = (a, b) => b - a;
const mul = (a, b) => a * b;
const div = (a, b) => b / a;

const solution = () => {
  const s = [];

  for(let i = 0; i < tokens.length; i++) {
    const token = tokens[i];

    if(token === '+') s.push(sum(s.pop(), s.pop()));
    else if(token === '-') s.push(subtract(s.pop(), s.pop()));
    else if(token === '*') s.push(mul(s.pop(), s.pop()));
    else if(token === '/') s.push(div(s.pop(), s.pop()));
    else s.push(mapper[token]);
  }

  return s[0].toFixed(2);
}