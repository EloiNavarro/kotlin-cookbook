# 🍳 Kotlin Cookbook

A focused collection of Kotlin snippets and explanations, created to support internal development and deepen understanding of key language features.

This repository is especially useful in mobile and Kotlin Multiplatform contexts, where concepts like structured concurrency, flow handling, and clean architecture can easily become sources of confusion or subtle bugs.

---

## 📘 What’s inside

This cookbook includes examples that are:

- Practical and copy-paste ready
- Minimal, focused, and self-contained
- Accompanied by short explanations and rationale

### ✅ Topics planned so far

- **Coroutines**
    - Structured concurrency
    - Scope best practices (`viewModelScope`, `supervisorScope`, etc.)
    - Error handling and `CoroutineExceptionHandler`
    - Cold vs hot flows
    - Collecting safely from UI layers

> More topics may be added over time depending on need.

---

## 🎯 Purpose

This is not a comprehensive reference, but rather a collection of distilled insights — a place to find clarity on tricky Kotlin patterns and move forward confidently when theory isn’t enough.

Whether you're onboarding to a Kotlin-heavy codebase or just want to reinforce your intuition, this cookbook is here to accelerate that process.

---

## 🧠 Philosophy

- 📚 **Focused examples over long explanations**
- ✨ **Idiomatic Kotlin only**
- 🧩 **Context is king**: no snippet exists in isolation
- 🛠 **Useful for thinking, not just copying**

---

## 📂 Structure

Each topic is structured as a folder with:
- A `README.md` explaining the concept and usage scenario
- One or more `.kt` files with runnable examples

---

## 🚧 Future topics (tentative)

- Testing flows and suspend functions
- DI in shared code (KMP-friendly approaches)
- Kotlin DSL tricks
- Error modeling with sealed classes
- `StateFlow` vs `SharedFlow` in UI layers

---

This project evolves organically. If you're reading this, you're welcome to explore and adapt anything you find useful.