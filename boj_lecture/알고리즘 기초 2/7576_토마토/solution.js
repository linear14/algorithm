const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n, m;
const arr = [];
rl.on('line', (input) => {
  if(!n) {
    [m, n] = input.split(' ').map(i => +i);
  }
  else {
    arr.push(input.split(' ').map(i => +i));
    if(arr.length === n) {
      rl.close();
    }
  }
}).on('close', () => {
  let unRipenTomatoCount = arr.flat().filter(item => item === 0).length;

  if(unRipenTomatoCount === 0) {
    console.log(0);
    return;
  }

  const dn = [0, 0, -1, 1];
  const dm = [1, -1, 0, 0];
  const q = new Queue();

  for(let i = 0; i < n; i++) {
    for(let j = 0; j < m; j++) {
      if(arr[i][j] === 1) {
        q.enqueue({ cn: i, cm: j, day: 0 });
      }
    }
  }

  while(q.size > 0) {
    const { cn, cm, day } = q.dequeue();
    
    for(let i = 0; i < 4; i++) {
      const nn = cn + dn[i];
      const nm = cm + dm[i];
      
      if(nn >= 0 && nn < n && nm >= 0 && nm < m) {
        if(arr[nn][nm] === 0) {
          if(--unRipenTomatoCount === 0) {
            console.log(day + 1);
            return;
          }
          arr[nn][nm] = 1;
          q.enqueue({ cn: nn, cm: nm, day: day + 1 });
        }
      }
    }
  }

  console.log(-1);
});

class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  enqueue(value) {
    const node = new Node(value);
    
    if(this.head === null) {
      this.head = node;
      this.tail = node;
    }
    else {
      this.tail.next = node;
      this.tail = node;
    }

    this.size++;
  }

  dequeue() {
    if(this.head === null) {
      return undefined;
    }

    const node = this.head;
    this.head = node.next;
    this.size--;

    if(this.size === 0) {
      this.head = null;
      this.tail = null;
    }

    return node.value;
  }
}