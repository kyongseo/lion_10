// 초기값
let basicDatas = [
    { id: 1, title: "Todo 1", done: false },
    { id: 2, title: "Todo 2", done: true }
];

const todoList = document.getElementById('todoList');
const todoInput = document.getElementById('todoInput');
const addBtn = document.getElementById('addBtn');

// 할 일 목록을 렌더링하는 함수
function renderTodos() {
    todoList.innerHTML = ''; 
    basicDatas.forEach(todo => {
        const li = document.createElement('li'); 
        li.textContent = todo.title; 

        if (todo.done) {
            li.classList.add('checked');
        }

        li.classList.add('todo-item'); 
        li.addEventListener('click', () => toggleTodoStatus(todo.id));
        
        // 삭제 버튼 생성, 이벤트 핸들러 추가
        const deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'X';
        deleteBtn.classList.add('deleteBtn'); 
        deleteBtn.addEventListener('click', () => deleteTodo(todo.id));

        li.appendChild(deleteBtn);
        todoList.appendChild(li); 
    });
}

//삭제
function deleteTodo(id) {
    basicDatas = basicDatas.filter(todo => todo.id !== id); 
    renderTodos(); 
}

//추가
function addTodo() {
    const title = todoInput.value.trim(); 
    if (title) { 
        const id = basicDatas.length + 1; // 배열의 길이 + 1을 새로운 ID로 사용
        basicDatas.push({ id, title, done: false }); 
        todoInput.value = ''; 
        renderTodos();
    }
}

// 추가 버튼 클릭 이벤트 핸들러 등록
addBtn.addEventListener('click', addTodo);
todoInput.addEventListener('keydown', (e) => {
    if (e.key === 'Enter') { 
        addTodo(); 
    }
});

renderTodos();
