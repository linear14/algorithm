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

    if (this.size === 0) {
      this.head = node;
      this.tail = node;
    } else {
      this.tail.next = node;
      this.tail = node;
    }
    this.size++;
  }

  dequeue() {
    if (this.size === 0) {
      return undefined;
    }

    if (this.size === 1) {
      const node = this.head;
      this.head = null;
      this.tail = null;
      this.size--;
      return node.value;
    }

    const node = this.head;
    this.head = this.head.next;
    this.size--;
    return node.value;
  }
}

const dx = [2, 0, -2, 0];
const dy = [0, -2, 0, 2];
const dirs = ['right', 'down', 'left', 'up'];
const toRight = {
    right: 'down',
    down : 'left',
    left : 'up',
    up   : 'right'
}

// 아.. 두 배 크기로 만들어야겠다. 
// 이웃 원소끼리 1로 동일한 값이 들어있다면.. 이게 선으로 연결된건지 떨어져있는건지 알 수 없네.. 
// (1번 테케의 [3,1] [3,2] 같은 케이스)

// 일단 50 * 50 배열을 만들어서, 배열에 선인지 아닌지를 판단하는 flag 값을 넣어줘야함 -> 100 * 100으로 변경
// map : 0 : 선 아님, 1 : 선, 2 : 이동 가능 선
const solution = (rectangle, characterX, characterY, itemX, itemY) => {
    const sortedRectangle = rectangle
        .sort((ra, rb) => (ra[0] + ra[1]) - (rb[0] + rb[1]))
        .map(r => r.map(item => item * 2));
    const map = Array.from({ length: 101 }, () => Array(101).fill(0));
    
    for(let i = 0; i < sortedRectangle.length; i++) {
        const [lx, ly, rx, ry] = sortedRectangle[i];
        
        for(let j = ly; j <= ry; j++) {
            map[lx][j] = 1;
            map[rx][j] = 1;
        }
        
        for(let j = lx; j <= rx; j++) {
            map[j][ly] = 1;
            map[j][ry] = 1;
        }
    }
    
    let cDir = 'up';
    let [cx, cy] = sortedRectangle[0];
    let [px, py] = [0, 0]
    
    while(true) {
        map[cx][cy] = 2;
        map[px][py] = 2;
        
        // 현재 위치에서 이동할 수 있는 연결된 모든 좌표 확인
        const dirWithLocation = [];
        const tempNextLocation = [];
        for(let i = 0; i < 4; i++) {
            const dir = dirs[i];
            const [nx, ny] = [cx + dx[i], cy + dy[i]];
            const [mx, my] = [cx + dx[i] / 2, cy + dy[i] / 2];
            
            // 마지막 지점에서 끝나는거 어떻게 체크할건데..? 체크 못하니깐 게속 마지막에 이상한 곳으로 감..
            if(nx > 0 && nx <= 100 && ny > 0 && ny <= 100 && map[mx][my] === 1) {
                tempNextLocation.push([dir, nx, ny, mx, my]);  
            }
        }
        
        // 새로 추가된 다음 경로들 중 처음 지점이 있는지 확인하기
        const isLineCheckFinished = tempNextLocation
            .find(([_, nx, ny, mx, my]) => {
                return nx === sortedRectangle[0][0] && 
                    ny === sortedRectangle[0][1] && 
                    map[nx][ny] === 2 && 
                    map[mx][my] === 1
            })

        // 처음 지점이 있다면 한바퀴 다 돌았다는 뜻이므로 종료
        if(isLineCheckFinished) {
            break;
        }
        
        dirWithLocation.push(...tempNextLocation);
        
        // 연결된 좌표가 없다는 말은 한바퀴 다 돌았다는 뜻과 동일
        if(dirWithLocation.length === 0) {
            break;   
        }
        // 연결된 좌표가 단 1개라면 이동. 만약 위치가 바뀌어야 한다면 dir을 변경해준다.
        else if(dirWithLocation.length === 1) {
            const [nDir, nx, ny, mx, my] = dirWithLocation[0];
            cDir = nDir;
            cx = nx;
            cy = ny;
            px = mx;
            py = my;
        }
        // 연결된 좌표가 2개 이상이라면, toRight(현재 진행 방향) 에 해당하는 좌표로 넘어간다.
        else {
            const item = dirWithLocation.find(([dir]) => dir === toRight[cDir]);
            if(!item) {
                break;
            }
            cDir = item[0];
            cx = item[1];
            cy = item[2];    
            px = item[3];
            py = item[4];
        }
    }

    map[sortedRectangle[0][0]][sortedRectangle[0][1] + 1] = 2;
    
    const isVisited = Array.from({ length: 101 }, () => Array(101).fill(false));
    const q = new Queue();
    isVisited[characterX * 2][characterY * 2] = true;
    q.enqueue({ 
        cx: characterX * 2, 
        cy: characterY * 2, 
        depth: 0 
    });
    
    while(q.size > 0) {
        const { cx, cy, depth } = q.dequeue();

        if(cx === itemX * 2 && cy === itemY * 2) {
            return depth;
        }
        
        for(let i = 0; i < 4; i++) {
            const [nx, ny] = [cx + dx[i], cy + dy[i]];
            const [mx, my] = [cx + dx[i] / 2, cy + dy[i] / 2];
            
            if(nx > 0 && nx <= 100 && ny > 0 && ny <= 100 && !isVisited[nx][ny]) {
                if(map[nx][ny] === 2 && map[mx][my] === 2) {
                    q.enqueue({ cx: nx, cy: ny, depth: depth + 1 });
                    isVisited[nx][ny] = true;
                }
            }
        }
    }
}